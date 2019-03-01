package com.tarbadev.carambar

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppProvider {
    @Provides
    @Named("fileName")
    fun provideFileName(): String {
        return "hello.txt"
    }
}