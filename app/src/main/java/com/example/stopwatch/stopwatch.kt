package com.example.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.stopwatch.R
/**
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mMessageEditText: EditText = findViewById(R.id.editText_send)
        val buttonSend: Button = findViewById(R.id.button_send)

        buttonSend.setOnClickListener {
            val message = mMessageEditText.text.toString().trim() // Move this line inside the click listener
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("SEND_KEY_VALUE", message)
            startActivity(secondActivityIntent)
        }
    }
}**/
