package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.repository

import `in`.aamir.ashraf.mydictionary.core.utils.Resource
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.WordInfoDao
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.DictionaryApi
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
):WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> {
        return flow {
            emit(Resource.Loading())

            val wordInfos = dao.getWordInfos(word).map{it.toWordInfo()}
            emit(Resource.Loading(data = wordInfos))
            try {
                val remoteWordInfos = api.getWordInfo(word)
                dao.deleteWordInfos(remoteWordInfos.map { it.word })

                dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

            }catch (e:HttpException){
                emit(Resource.Error("oops something went wrong ${e.code()}",
                    data = wordInfos))
            }
            catch (e:IOException){
                emit(Resource.Error("please check your internet connection",
                    data = wordInfos))
            }

            //now the important part
            val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
            emit(Resource.Success(newWordInfos))
        }

    }

}