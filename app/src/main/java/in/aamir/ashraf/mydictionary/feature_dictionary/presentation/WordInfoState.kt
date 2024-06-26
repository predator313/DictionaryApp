package `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation

import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems:List<WordInfo> = emptyList(),
    val isLoading:Boolean = false
)