package com.tarbadev.carambar

import dagger.Module
import dagger.Provides
import org.springframework.web.client.RestTemplate
import javax.inject.Named

@Module
class TestAppProvider {
    @Provides
    @Named("fileName")
    fun provideFileName(): String {
        return "testFileName.txt"
    }
}