package com.example.caribbeandelights

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.core.content.ContextCompat
import com.example.caribbeandelights.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences: SharedPreferences = getSharedPreferences("PasswordsAndEmails", Context.MODE_PRIVATE)
        val signUpBtn = binding.signUpBtn

        signUpBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val email = binding.usernameEdt.editableText.toString()
                val password = binding.passwordEdt.editableText.toString()
                val confirmPassword = binding.confirmPasswordEdt.editableText.toString()

                val specialChar = setOf('!', '@', '#', '$', '%', '^', '&', '*')
                val emailFound = sharedPreferences.getString(email, "")

                if(password != confirmPassword || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.noMatch.setText(R.string.no_match)
                    binding.noMatch.visibility = View.VISIBLE
                } else if (emailFound != "") {
                    binding.noMatch.setText(R.string.email_exists)
                    binding.noMatch.visibility = View.VISIBLE
                } else{
                    binding.noMatch.visibility = View.INVISIBLE

                    var requirementsCheck = 0

                    if (password.length < 8) {
                        binding.requirement1.setTextColor(Color.RED)
                    } else {
                        binding.requirement1.setTextColor(Color.BLACK)
                        requirementsCheck++;
                    }

                    if (password.any(){it.isDigit()}) {
                        binding.requirement2.setTextColor(Color.BLACK)
                        requirementsCheck++;
                    } else {
                        binding.requirement2.setTextColor(Color.RED)
                        requirementsCheck++;
                    }

                    if (password.any(){it in specialChar}) {
                        binding.requirement3.setTextColor(Color.BLACK)
                        requirementsCheck++;
                    } else {
                        binding.requirement3.setTextColor(Color.RED)
                    }

                    if (password.any { it.isUpperCase() }) {
                        binding.requirement4.setTextColor(Color.BLACK)
                        requirementsCheck++;
                    } else {
                        binding.requirement4.setTextColor(Color.RED)
                    }

                    if (password.any { it.isLowerCase() }) {
                        binding.requirement5.setTextColor(Color.BLACK)
                        requirementsCheck++;
                    } else {
                        binding.requirement5.setTextColor(Color.RED)
                    }

                    if(requirementsCheck == 5) {
                        val editor = sharedPreferences.edit()
                        editor.putString(email, password).apply()

                        val intent = Intent(this@SignUp, Recipes2::class.java)
                        startActivity(intent)
                    }
                }

            }
        })
    }

}