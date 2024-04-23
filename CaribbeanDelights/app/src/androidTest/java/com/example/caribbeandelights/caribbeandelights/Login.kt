package com.example.caribbeandelights

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.caribbeandelights.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences: SharedPreferences = getSharedPreferences("PasswordsAndEmails", Context.MODE_PRIVATE)

        val loginBtn = binding.signInBtn

        loginBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val email = binding.usernameEdt.editableText.toString()
                val password = binding.passwordEdt.editableText.toString()

                val foundEmailAndPassword = sharedPreferences.getString(email, "")

                if(foundEmailAndPassword == "" || foundEmailAndPassword != password) {
                    binding.incorrectTxt.visibility = View.VISIBLE
                } else {
                    binding.incorrectTxt.visibility = View.INVISIBLE
                    val intent = Intent(this@Login, Recipes2::class.java)
                    startActivity(intent)
                }

            }
        })


    }
}