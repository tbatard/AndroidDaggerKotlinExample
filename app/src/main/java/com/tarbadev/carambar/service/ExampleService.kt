package com.tarbadev.carambar.service

import com.tarbadev.carambar.repository.InternalFileRepository
import javax.inject.Inject

class ExampleService @Inject constructor(
    private val internalFileRepository: InternalFileRepository
) {

    fun getHello(): String {
        return "Hello Home!"
    }

    fun saveText(): String {
        return internalFileRepository.save("Hello Storage")
    }

    fun getSavedText(): String {
        return internalFileRepository.read()
    }
}
