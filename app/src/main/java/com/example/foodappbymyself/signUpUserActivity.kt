package com.example.foodappbymyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodappbymyself.databinding.ActivitySignUpUserBinding
import android.content.Intent


class signUpUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goLoginUserPage.setOnClickListener {
            val intent = Intent(this@signUpUserActivity, LoginUserActivity :: class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this@signUpUserActivity, LocationActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}