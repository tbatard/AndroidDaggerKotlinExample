package com.tarbadev.carambar.blackbox.view

import com.tarbadev.carambar.R
import com.tarbadev.carambar.ui.activity.MainActivity

class HomeView(activity: MainActivity) : BaseView(activity) {

    fun clickOnDisplayButton() {
        clickOnButton(R.id.buttonHello)
    }

    fun getText(): String {
        return getTextViewText(R.id.helloTextView)
    }
}