package com.example.caribbeandelights

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.caribbeandelights.databinding.ActivityConchFrittersBinding

class ConchFritters : AppCompatActivity() {
    private lateinit var binding: ActivityConchFrittersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConchFrittersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences: SharedPreferences = getSharedPreferences("SharedFile", Context.MODE_PRIVATE)

        val homeBtn = binding.homeBtn
        val favouritesBtn = binding.favourites
        val toFavourites = binding.toFavourites
        val editor = sharedPreferences.edit()

        val inFavourites = sharedPreferences.getString("FrittersFavourites", null)
        var isNotSelected: Boolean = true

        if(inFavourites == null) {
            editor.putString("FrittersFavourites", "false").apply()
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
                    editor.remove("FrittersFavourites").apply()
                    editor.putString("FrittersFavourites", "true").apply()
                    Toast.makeText(this@ConchFritters, "Added to Favourites", Toast.LENGTH_LONG)
                } else {
                    binding.favourites.setImageResource(R.drawable.star_unselected)
                    isNotSelected = true
                    editor.remove("FrittersFavourites").apply()
                    editor.putString("FrittersFavourites", "false").apply()
                    Toast.makeText(this@ConchFritters, "Removed from Favourites", Toast.LENGTH_LONG)
                }
            }
        })

        homeBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@ConchFritters, Recipes2::class.java)
                startActivity(intent)
            }
        })

        toFavourites.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@ConchFritters, Favourites::class.java)
                startActivity(intent)
            }
        })
    }
}