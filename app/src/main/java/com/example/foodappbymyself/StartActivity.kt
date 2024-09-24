package com.example.foodappbymyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodappbymyself.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goUserLoginBtn.setOnClickListener {
            val intent = Intent(this@StartActivity, LoginUserActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}