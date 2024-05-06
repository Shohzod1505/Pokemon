package ru.itis.kpfu.core.common.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AndroidModule(
    private val application: Application,
) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = application
}
