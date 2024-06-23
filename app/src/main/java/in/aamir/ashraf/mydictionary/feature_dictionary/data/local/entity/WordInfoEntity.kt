package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.Meaning
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity (
    val meanings: List<Meaning>,
    val phonetic: String,

    val word: String,
    @PrimaryKey(autoGenerate = true) val id:Long?=null

){
    fun toWordInfo():WordInfo{
        return WordInfo(
            meanings = meanings,
            phonetic = phonetic,
            word = word
        )
    }
}