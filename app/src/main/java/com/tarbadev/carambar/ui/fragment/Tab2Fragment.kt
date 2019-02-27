package com.tarbadev.carambar.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.tarbadev.carambar.R
import com.tarbadev.carambar.service.ExampleService
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class Tab2Fragment : BaseFragment() {
    @Inject
    lateinit var exampleService: ExampleService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun displaySavedText() {
        val text = exampleService.getSavedText()
        val helloTextView = findViewById<TextView>(R.id.savedTextView)
        helloTextView.text = text
    }

    private fun setupListeners() {
        val displayButton = findViewById<Button>(R.id.buttonRead)
        displayButton.setOnClickListener {
            displaySavedText()
        }

        val saveButton = findViewById<Button>(R.id.buttonSave)
        saveButton.setOnClickListener {
            exampleService.saveText()
        }
    }
}