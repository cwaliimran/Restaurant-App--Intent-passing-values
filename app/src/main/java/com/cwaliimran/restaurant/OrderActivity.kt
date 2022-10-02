package com.cwaliimran.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.Group

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Order details"

        val bundle = intent.extras
        if (bundle != null) {
            val burger = bundle.getString("burger")
            val fries = bundle.getString("fries")
            val shawarma = bundle.getString("shawarma")
            val payVia = bundle.getString("payvia")
            var totalBill = 0
            if (burger == "") {
                val group = findViewById<Group>(R.id.group)
                group.visibility = View.GONE
            } else {
                val textView10 = findViewById<TextView>(R.id.textView10)
                val textView11 = findViewById<TextView>(R.id.textView11)
                textView10.text = burger
                textView11.text = (burger?.toInt()!! * 350).toString()
                totalBill = burger.toInt() * 350
            }
            if (fries == "") {
                val group2 = findViewById<Group>(R.id.group2)
                group2.visibility = View.GONE
            } else {
                val textView13 = findViewById<TextView>(R.id.textView13)
                val textView14 = findViewById<TextView>(R.id.textView14)
                textView13.text = fries
                textView14.text = (fries?.toInt()!! * 150).toString()
                totalBill += fries.toInt() * 150
            }
            if (shawarma == "") {
                val group3 = findViewById<Group>(R.id.group3)
                group3.visibility = View.GONE
            } else {
                val textView16 = findViewById<TextView>(R.id.textView16)
                val textView17 = findViewById<TextView>(R.id.textView17)
                textView16.text = shawarma
                textView17.text = (shawarma?.toInt()!! * 120).toString()
                totalBill += shawarma.toInt() * 120
            }


            //pay via
            val textView19 = findViewById<TextView>(R.id.textView19)
            textView19.text = payVia

            //total bill
            val textView21 = findViewById<TextView>(R.id.textView21)
            textView21.text = totalBill.toString()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
