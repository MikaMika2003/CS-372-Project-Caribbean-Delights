package com.example.caribbeandelights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.caribbeandelights.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val signInBtn = binding.signInBtn
        val signUpBtn = binding.signUpBtn

        signInBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Welcome, Login::class.java)
                startActivity(intent)
            }
        })

        signUpBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Welcome, SignUp::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onBackPressed() {

    }
}