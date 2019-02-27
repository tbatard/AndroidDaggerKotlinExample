package com.tarbadev.carambar.blackbox

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tarbadev.carambar.TestAndroidDaggerKotlinExampleApplication
import com.tarbadev.carambar.blackbox.view.HomeView
import com.tarbadev.carambar.ui.activity.MainActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestAndroidDaggerKotlinExampleApplication::class)
class HomeBlackboxTest {

    @Test
    fun `home shows a button Display that displays 'Hello!'`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val mainActivityView = HomeView(activity)

            mainActivityView.clickOnDisplayButton()

            assertThat(mainActivityView.getText()).isEqualTo("Hello Home!")
        }
    }
}