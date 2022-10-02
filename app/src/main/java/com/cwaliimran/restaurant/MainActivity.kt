package com.cwaliimran.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val checkBoxBurger = findViewById<CheckBox>(R.id.checkBoxBurger)
        val checkBoxFries = findViewById<CheckBox>(R.id.checkBoxFries)
        val checkBoxShawrma = findViewById<CheckBox>(R.id.checkBoxShawrma)
        val etFries = findViewById<EditText>(R.id.etFries)
        val etBurger = findViewById<EditText>(R.id.etBurger)
        val etShawrma = findViewById<EditText>(R.id.etShawrma)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var burgerQty = etBurger.text.toString()
            var friesQty = etFries.text.toString()
            var shawarmaQty = etShawrma.text.toString()
            if (checkBoxBurger.isChecked && burgerQty.isEmpty()) {
                Toast.makeText(this, "Enter burger value", Toast.LENGTH_SHORT).show()
            } else if (checkBoxFries.isChecked && friesQty.isEmpty()) {
                Toast.makeText(this, "Enter fries value", Toast.LENGTH_SHORT).show()
            } else if (checkBoxShawrma.isChecked && shawarmaQty.isEmpty()) {
                Toast.makeText(this, "Enter shawarma value", Toast.LENGTH_SHORT).show()
            } else {
                if (!checkBoxBurger.isChecked) {
                    burgerQty = ""
                }
                if (!checkBoxFries.isChecked) {
                    friesQty = ""
                }
                if (!checkBoxShawrma.isChecked) {
                    shawarmaQty = ""
                }
                if (burgerQty == "" && friesQty == "" && shawarmaQty == "") {
                    Toast.makeText(this, "No items selected", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this, OrderActivity::class.java)
                intent.putExtra("burger", burgerQty)
                intent.putExtra("fries", friesQty)
                intent.putExtra("shawarma", shawarmaQty)
                val id = radioGroup.checkedRadioButtonId
                var payment = ""
                payment = if (id == R.id.radioButton) {
                    "Cash"
                } else {
                    "Card"
                }
                intent.putExtra("payvia", payment)
                startActivity(intent)
            }
        }
    }
}