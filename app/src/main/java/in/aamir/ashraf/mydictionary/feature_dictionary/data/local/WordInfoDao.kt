package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.entity.WordInfoEntity



@Dao
interface WordInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(list: List<WordInfoEntity>)

    @Query("delete from wordinfoentity where word in (:words)")
    suspend fun deleteWordInfos(words:List<String>)

    @Query("select * from wordinfoentity where word like '%' || :word || '%'")
    suspend fun getWordInfos(word:String):List<WordInfoEntity>


}