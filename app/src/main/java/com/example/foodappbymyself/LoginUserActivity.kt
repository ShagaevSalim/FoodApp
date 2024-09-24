package com.example.foodappbymyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodappbymyself.databinding.ActivityLoginUserBinding
import android.content.Intent

class LoginUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSignUpUser.setOnClickListener{
            val intent = Intent(this@LoginUserActivity, signUpUserActivity :: class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this@LoginUserActivity, MainActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}