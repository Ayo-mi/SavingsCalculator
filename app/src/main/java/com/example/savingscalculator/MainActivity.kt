package com.example.savingscalculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.savingscalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var mainView : ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainView = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainView.root)

        mainView.compute.setOnClickListener {
            try {
                val target = mainView.target.text.toString().toFloat()
                val save = mainView.save.text.toString().toFloat()
                if (target < save) {
                    Toast.makeText(
                        this,
                        "Target savings can't br lesser than amount save yearly",
                        Toast.LENGTH_LONG
                    ).show()
                }
                val dec = DecimalFormat("#,###.00")

                val years = (target / save).toInt()
                mainView.result.text =
                    "It will take approx. $years years to save " +
                            "$${dec.format(target)}\nwith a yearly savings of $${dec.format(save)}"
                closeKeyBoard()
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid action", Toast.LENGTH_LONG).show()
            }
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