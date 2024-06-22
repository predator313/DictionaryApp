package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.dto

import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
){
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map {it.toDefinition()
            },
            partOfSpeech = partOfSpeech
        )
    }
}