package com.example.caribbeandelights

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.caribbeandelights.databinding.ActivityJohnnyBreadBinding

class JohnnyBread : AppCompatActivity() {
    private lateinit var binding: ActivityJohnnyBreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJohnnyBreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences: SharedPreferences = getSharedPreferences("SharedFile", Context.MODE_PRIVATE)

        val homeBtn = binding.homeBtn
        val favouritesBtn = binding.favourites
        val toFavourites = binding.toFavourites
        val editor = sharedPreferences.edit()

        val inFavourites = sharedPreferences.getString("BreadFavourites", null)
        var isNotSelected: Boolean = true

        if(inFavourites == null) {
            editor.putString("BreadFavourites", "false").apply()
            isNotSelected = true
            binding.favourites.setImageResource(R.drawable.star_unselected)
        } else if(inFavourites == "true") {
            isNotSelected = false
            binding.favourites.setImageResource(R.drawable.star_selected)
        } else if (inFavourites == "false"){
            isNotSelected = true
            binding.favourites.setImageResource(R.drawable.star_unselected)
        }

        favouritesBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isNotSelected) {
                    binding.favourites.setImageResource(R.drawable.star_selected)
                    isNotSelected = false
                    editor.remove("BreadFavourites").apply()
                    editor.putString("BreadFavourites", "true").apply()
                    Toast.makeText(this@JohnnyBread, "Added to Favourites", Toast.LENGTH_LONG)
                } else {
                    binding.favourites.setImageResource(R.drawable.star_unselected)
                    isNotSelected = true
                    editor.remove("BreadFavourites").apply()
                    editor.putString("BreadFavourites", "false").apply()
                    Toast.makeText(this@JohnnyBread, "Removed from Favourites", Toast.LENGTH_LONG)
                }
            }
        })

        homeBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@JohnnyBread, Recipes2::class.java)
                startActivity(intent)
            }
        })

        toFavourites.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@JohnnyBread, Favourites::class.java)
                startActivity(intent)
            }
        })
    }
}