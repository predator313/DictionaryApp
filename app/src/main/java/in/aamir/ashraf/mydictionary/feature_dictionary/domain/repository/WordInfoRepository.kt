package `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.repository

import `in`.aamir.ashraf.mydictionary.core.utils.Resource
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String):Flow<Resource<List<WordInfo>>>
}