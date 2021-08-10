package com.lifetap.assignment.di.module

import android.content.Context
import com.lifetap.assignment.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun provideContext(app: BaseApplication): Context = app

}