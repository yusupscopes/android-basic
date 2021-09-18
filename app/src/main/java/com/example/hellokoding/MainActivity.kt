package com.example.hellokoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuText: TextView = findViewById(R.id.menuText)
        val button1 : Button = findViewById(R.id.btn1)
        val nameText : EditText = findViewById(R.id.nameText)
        val greetingText : TextView = findViewById(R.id.greetingText)
        val foodImage : ImageView = findViewById(R.id.foodImage)

        val listFood = arrayOf("burger", "pancake", "sandwich")
        menuText.text = getString(R.string.menu, listFood.joinToString())

        button1.setOnClickListener {
            greetingText.text = ""
            val name = nameText.text.toString()

            val foodNameValidationString = getString(R.string.food_name_validation)
            if (name.trim() == "") {
                Toast.makeText(this@MainActivity, foodNameValidationString, Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val imageRes = resources.getIdentifier(name, "drawable", packageName)
            if (imageRes > 0) {
                val greetingString = getString(R.string.greeting, name)
                greetingText.text = greetingString
                foodImage.setImageResource(imageRes)
            } else {
                val greetingString = getString(R.string.food_not_found, name)
                greetingText.text = greetingString
                val imageDefault = resources.getIdentifier("resource_default", "drawable", packageName)
                foodImage.setImageResource(imageDefault)
            }

        }
    }
}