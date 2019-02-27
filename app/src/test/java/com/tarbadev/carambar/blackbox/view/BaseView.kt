package com.tarbadev.carambar.blackbox.view

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationItemView

abstract class BaseView(protected val activity: Activity) {

    protected fun getTextViewText(id: Int): String {
        val textView = activity.findViewById(id) as TextView
        return textView.text as String
    }

    protected fun clickOnButton(id: Int) {
        val textView = activity.findViewById(id) as Button
        textView.performClick()
    }
}