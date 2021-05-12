package edu.ni.abra.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.ni.abra.util.AdapterCats
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdaptersModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterCats {
        return AdapterCats()
    }
}