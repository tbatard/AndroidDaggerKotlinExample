package com.tarbadev.carambar.repository

import android.content.Context
import com.tarbadev.carambar.annotation.AllOpen
import javax.inject.Inject
import javax.inject.Named

@AllOpen
class InternalFileRepository @Inject constructor(
    @Named("ApplicationContext") private val context: Context,
    @Named("fileName") private val fileName: String
) {
    fun read(): String {
        return String(context.openFileInput(fileName).readBytes())
    }

    fun save(text: String): String {
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(text.toByteArray())
        }

        return text
    }
}
