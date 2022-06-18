package com.noobshubham.exviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.currentNumber.observe(this, Observer {
            val number: TextView = findViewById(R.id.number)
            number.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            val boolean: TextView = findViewById(R.id.boolean_number)
            boolean.text = it.toString()
        })

        incrementNumberText()

    }

    fun incrementNumberText() {
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}