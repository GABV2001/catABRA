package edu.ni.abra.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.ni.abra.repository.CatRepository
import edu.ni.abra.retrofit.CatNetworkMapper
import edu.ni.abra.retrofit.CatRetrofit
import edu.ni.abra.room.CacheMapper
import edu.ni.abra.room.CatDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCatRepository(
        catDao: CatDao,
        catRetrofit: CatRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: CatNetworkMapper
    ):CatRepository {
        return CatRepository(catDao, catRetrofit, cacheMapper, networkMapper)
    }
}