package com.example.foodappbymyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodappbymyself.Fragments.SuccessPay
import com.example.foodappbymyself.databinding.ActivityDetails2Binding
import com.example.foodappbymyself.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {

    private lateinit var binding : ActivityDetails2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backStack.setOnClickListener {
            onBackPressed()
        }

        binding.placeMyOrder.setOnClickListener {
            val bottomFragment = SuccessPay()
            bottomFragment.show(supportFragmentManager, "Test")
        }

        val totalPrice = intent.getStringExtra("totalPrice")
        binding.textView23.text = totalPrice
    }
}