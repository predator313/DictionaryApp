package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.dto

import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.entity.WordInfoEntity
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val licenseDto: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,

    val word: String
){
    fun toWordInfoEntity():WordInfoEntity{
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,

            word = word
        )
    }
}