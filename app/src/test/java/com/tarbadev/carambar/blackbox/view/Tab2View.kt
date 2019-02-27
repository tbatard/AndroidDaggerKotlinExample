package com.tarbadev.carambar.blackbox.view

import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.tarbadev.carambar.R
import com.tarbadev.carambar.ui.activity.MainActivity

class Tab2View(activity: MainActivity) : BaseView(activity) {

    fun clickOnTab2Tab() {
        val textView = activity.findViewById(com.tarbadev.carambar.R.id.bottom_navigation_tab2) as BottomNavigationItemView
        textView.performClick()
    }

    fun clickOnReadButton() {
        clickOnButton(R.id.buttonRead)
    }

    fun clickOnSaveButton() {
        clickOnButton(R.id.buttonSave)
    }

    fun getText(): String {
        return getTextViewText(R.id.savedTextView)
    }
}