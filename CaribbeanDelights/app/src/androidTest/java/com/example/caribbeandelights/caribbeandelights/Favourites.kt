package com.example.caribbeandelights

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.caribbeandelights.databinding.ActivityFavouritesBinding

class Favourites : AppCompatActivity() {
    private lateinit var binding: ActivityFavouritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouritesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences: SharedPreferences = getSharedPreferences("SharedFile", Context.MODE_PRIVATE)

        val macInFavourites = sharedPreferences.getString("MacaroniFavourites", null)
        val riceInFavourites = sharedPreferences.getString("RiceFavourites", null)
        val souseInFavourites = sharedPreferences.getString("SouseFavourites", null)
        val breadInFavourites = sharedPreferences.getString("BreadFavourites", null)
        val frittersInFavourites = sharedPreferences.getString("FrittersFavourites", null)
        val homeBtn = binding.homeBtn


        if(macInFavourites == "true") {
            binding.macaroniBck.visibility = View.VISIBLE
            binding.difficultyMac.visibility = View.VISIBLE
            binding.difficultyLevelMac.visibility = View.VISIBLE
            binding.macaroniBtn.visibility = View.VISIBLE
            binding.macaroniTxt.visibility = View.VISIBLE
            binding.macaroniImg.visibility = View.VISIBLE
        } else if (macInFavourites == "false") {
            binding.macaroniBck.visibility = View.GONE
            binding.difficultyMac.visibility = View.GONE
            binding.difficultyLevelMac.visibility = View.GONE
            binding.macaroniBtn.visibility = View.GONE
            binding.macaroniTxt.visibility = View.GONE
            binding.macaroniImg.visibility = View.GONE
        }

        if(riceInFavourites == "true") {
            binding.riceImg.visibility = View.VISIBLE
            binding.riceTxt.visibility = View.VISIBLE
            binding.peasNRiceBtn.visibility = View.VISIBLE
            binding.difficultyLevelRice1.visibility = View.VISIBLE
            binding.difficultyLevelRice2.visibility = View.VISIBLE
            binding.difficultyRice.visibility = View.VISIBLE
            binding.peasNRiceBck.visibility = View.VISIBLE
        } else if(riceInFavourites == "false") {
            binding.riceImg.visibility = View.GONE
            binding.riceTxt.visibility = View.GONE
            binding.peasNRiceBtn.visibility = View.GONE
            binding.difficultyLevelRice1.visibility = View.GONE
            binding.difficultyLevelRice2.visibility = View.GONE
            binding.difficultyRice.visibility = View.GONE
            binding.peasNRiceBck.visibility = View.GONE
        }

        if(souseInFavourites == "true") {
            binding.souseBtn.visibility = View.VISIBLE
            binding.souseBck.visibility = View.VISIBLE
            binding.souseImg.visibility = View.VISIBLE
            binding.souseTxt.visibility = View.VISIBLE
            binding.difficultyLevelSouse1.visibility = View.VISIBLE
            binding.difficultyLevelSouse2.visibility = View.VISIBLE
            binding.difficultyLevelSouse3.visibility = View.VISIBLE
            binding.difficultySouse.visibility = View.VISIBLE
        } else if(souseInFavourites == "false") {
            binding.souseBtn.visibility = View.GONE
            binding.souseBck.visibility = View.GONE
            binding.souseImg.visibility = View.GONE
            binding.souseTxt.visibility = View.GONE
            binding.difficultyLevelSouse1.visibility = View.GONE
            binding.difficultyLevelSouse2.visibility = View.GONE
            binding.difficultyLevelSouse3.visibility = View.GONE
            binding.difficultySouse.visibility = View.GONE
        }

        if(breadInFavourites == "true") {
            binding.johnnyBreadBtn.visibility = View.VISIBLE
            binding.johnnyBreadBck.visibility = View.VISIBLE
            binding.johnnyBreadImg.visibility = View.VISIBLE
            binding.johnnyBreadTxt.visibility = View.VISIBLE
            binding.difficultyBread.visibility = View.VISIBLE
            binding.difficultyLevelBread1.visibility = View.VISIBLE
            binding.difficultyLevelBread2.visibility = View.VISIBLE
        } else if(breadInFavourites == "false") {
            binding.johnnyBreadBtn.visibility = View.GONE
            binding.johnnyBreadBck.visibility = View.GONE
            binding.johnnyBreadImg.visibility = View.GONE
            binding.johnnyBreadTxt.visibility = View.GONE
            binding.difficultyBread.visibility = View.GONE
            binding.difficultyLevelBread1.visibility = View.GONE
            binding.difficultyLevelBread2.visibility = View.GONE
        }

        if(frittersInFavourites == "true") {
            binding.frittersBtn.visibility = View.VISIBLE
            binding.frittersBck.visibility = View.VISIBLE
            binding.frittersImg.visibility = View.VISIBLE
            binding.frittersTxt.visibility = View.VISIBLE
            binding.difficultyFritters.visibility = View.VISIBLE
            binding.difficultyLevelFritters1.visibility = View.VISIBLE
        } else if (frittersInFavourites == "false") {
            binding.frittersBtn.visibility = View.GONE
            binding.frittersBck.visibility = View.GONE
            binding.frittersImg.visibility = View.GONE
            binding.frittersTxt.visibility = View.GONE
            binding.difficultyFritters.visibility = View.GONE
            binding.difficultyLevelFritters1.visibility = View.GONE
        }

        val macaroniBtn = binding.macaroniBtn
        val riceBtn = binding.peasNRiceBtn
        val souseBtn = binding.souseBtn
        val breadBtn = binding.johnnyBreadBtn
        val frittersBtn = binding.frittersBtn

        macaroniBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, Macaroni::class.java)
                startActivity(intent)
            }
        })

        riceBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, PeasNRice::class.java)
                startActivity(intent)
            }
        })

        souseBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, ChickenSouse::class.java)
                startActivity(intent)
            }
        })

        breadBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, JohnnyBread::class.java)
                startActivity(intent)
            }
        })

        frittersBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, ConchFritters::class.java)
                startActivity(intent)
            }
        })

        homeBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Favourites, Recipes2::class.java)
                startActivity(intent)
            }
        })

    }
}