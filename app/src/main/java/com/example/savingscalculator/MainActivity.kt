package com.example.savingscalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.savingscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainView : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainView = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainView.root)

        try {
            mainView.compute.setOnClickListener {

                closeKeyBoard()
            }
        }catch (e : Exception){
            Toast.makeText(this, "Invalid action", Toast.LENGTH_LONG).show()
        }
    }

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}