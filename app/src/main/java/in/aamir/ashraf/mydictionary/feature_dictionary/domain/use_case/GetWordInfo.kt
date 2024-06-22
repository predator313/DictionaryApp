package `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.use_case

import `in`.aamir.ashraf.mydictionary.core.utils.Resource
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word:String):Flow<Resource<List<WordInfo>>>{
        if(word.isBlank())return flow {  }
        return repository.getWordInfo(word)
    }
}