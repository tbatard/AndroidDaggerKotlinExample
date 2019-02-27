package com.tarbadev.carambar.service

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.tarbadev.carambar.repository.InternalFileRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ExampleServiceTest {

    private lateinit var exampleService: ExampleService
    private val internalFileRepository: InternalFileRepository = mock()

    @BeforeEach
    fun setup() {
        exampleService = ExampleService(internalFileRepository)
    }


    @Test
    fun `getHello returns Hello`() {
        assertThat(exampleService.getHello()).isEqualTo("Hello Home!")
    }

    @Test
    fun `saveText saves text and returns it`() {
        val text = "Hello Storage"

        given(internalFileRepository.save(any())).willReturn(text)

        assertThat(exampleService.saveText()).isEqualTo(text)

        verify(internalFileRepository).save(text)
    }

    @Test
    fun `getSavedText returns the text from repository`() {
        val text = "Example of text to read"

        given(internalFileRepository.read()).willReturn(text)

        assertThat(exampleService.getSavedText()).isEqualTo(text)
    }
}