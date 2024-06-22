package `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.utils.JsonParser
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.model.Meaning
@ProvidedTypeConverter  //in case of providedTypeConverter we can use the parameter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }
    @TypeConverter
    fun toMeaningsJson(meanings:List<Meaning>):String{
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?:"[]"
    }
}