package `in`.aamir.ashraf.mydictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.Converters
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.WordInfoDao
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.local.WordInfoDataBase
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.DictionaryApi
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.remote.RetrofitInstance
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import `in`.aamir.ashraf.mydictionary.feature_dictionary.data.utils.GsonParser
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.repository.WordInfoRepository
import `in`.aamir.ashraf.mydictionary.feature_dictionary.domain.use_case.GetWordInfo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DictionaryModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase( repository: WordInfoRepository):GetWordInfo{
        return GetWordInfo(repository)

    }
    @Provides
    @Singleton
    fun provideWordInfoRepository(api: DictionaryApi,db:WordInfoDataBase):WordInfoRepository{
        return WordInfoRepositoryImpl(api,db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app:Application):WordInfoDataBase{
        return Room.databaseBuilder(
            app,
            WordInfoDataBase::class.java,
            "wordInfo_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }
    @Provides
    @Singleton
    fun provideDictionaryApi():DictionaryApi{
        return RetrofitInstance.api
    }
}