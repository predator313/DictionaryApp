package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.dto

import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val synonyms: List<String>
){
    //crate the mapper for each dto
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            synonyms = synonyms
        )
    }
}