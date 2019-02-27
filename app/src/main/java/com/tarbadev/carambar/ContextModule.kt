package com.tarbadev.carambar

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ContextModule(private val context: Context) {

    @Provides
    @Named("ApplicationContext")
    fun provideContext(): Context {
        return context
    }
}