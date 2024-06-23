package `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model

import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.dto.LicenseDto
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.dto.MeaningDto

data class WordInfo(

    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)
