package com.tarbadev.carambar.blackbox

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tarbadev.carambar.TestAndroidDaggerKotlinExampleApplication
import com.tarbadev.carambar.blackbox.view.Tab2View
import com.tarbadev.carambar.ui.activity.MainActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestAndroidDaggerKotlinExampleApplication::class)
class Tab2BlackboxTest {
    companion object {
        const val FILENAME = "testFileName.txt"
    }

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Before
    fun setupBlackbox() {
        context.deleteFile(FILENAME)
    }

    @Test
    fun `tab2 shows a button Save that creates a file with some text`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val tab2View = Tab2View(activity)
            tab2View.clickOnTab2Tab()

            tab2View.clickOnSaveButton()

            assertThat(getInternalFileContent()).isEqualTo("Hello Storage")
        }
    }

    @Test
    fun `tab2 shows a button Read that reads a file and displays it`() {
        writeInternalFile("New file Content")

        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val tab2View = Tab2View(activity)
            tab2View.clickOnTab2Tab()

            tab2View.clickOnReadButton()

            assertThat(tab2View.getText()).isEqualTo("New file Content")
        }
    }

    private fun getInternalFileContent(): String {
        val fileInput = context.openFileInput(FILENAME)
        return String(fileInput.readBytes())
    }

    private fun writeInternalFile(fileContent: String) {
        context.openFileOutput(FILENAME, Context.MODE_PRIVATE).use {
            it.write(fileContent.toByteArray())
        }
    }
}