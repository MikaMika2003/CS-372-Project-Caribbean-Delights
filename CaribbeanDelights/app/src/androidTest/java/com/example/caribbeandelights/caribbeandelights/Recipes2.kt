package com.example.caribbeandelights

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.caribbeandelights.databinding.ActivityRecipes2Binding

class Recipes2 : AppCompatActivity() {
    private lateinit var binding: ActivityRecipes2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipes2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val macaroniBtn = binding.macaroniBtn
        val riceBtn = binding.peasNRiceBtn
        val souseBtn = binding.souseBtn
        val breadBtn = binding.johnnyBreadBtn
        val frittersBtn = binding.frittersBtn
        val favouriteBtn = binding.favourites
        val searchBox = binding.search

        //Spinner
        val spinnerOptions = binding.spinner
        val arrayFrom = resources.getStringArray(R.array.Options)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayFrom)
        spinnerOptions.adapter = adapter

        spinnerOptions.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val option = parent?.getItemAtPosition(position) as String

                when(option) {
                    "All" -> showAll()
                    "Breakfast" -> showBreakfast()
                    "Lunch/Dinner" -> showLunchDinner()
                    "Side" -> showSide()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //Search
        searchBox.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        //Buttons
        macaroniBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, Macaroni::class.java)
                startActivity(intent)
            }
        })

        riceBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, PeasNRice::class.java)
                startActivity(intent)
            }
        })

        souseBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, ChickenSouse::class.java)
                startActivity(intent)
            }
        })

        breadBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, JohnnyBread::class.java)
                startActivity(intent)
            }
        })

        frittersBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, ConchFritters::class.java)
                startActivity(intent)
            }
        })

        favouriteBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@Recipes2, Favourites::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_logout -> {
                val intent = Intent(this, Welcome::class.java)
                startActivity(intent)
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    fun showAll() {
        binding.macaroniBck.visibility = View.VISIBLE
        binding.difficultyMac.visibility = View.VISIBLE
        binding.difficultyLevelMac.visibility = View.VISIBLE
        binding.macaroniBtn.visibility = View.VISIBLE
        binding.macaroniTxt.visibility = View.VISIBLE
        binding.macaroniImg.visibility = View.VISIBLE

        binding.riceImg.visibility = View.VISIBLE
        binding.riceTxt.visibility = View.VISIBLE
        binding.peasNRiceBtn.visibility = View.VISIBLE
        binding.difficultyLevelRice1.visibility = View.VISIBLE
        binding.difficultyLevelRice2.visibility = View.VISIBLE
        binding.difficultyRice.visibility = View.VISIBLE
        binding.peasNRiceBck.visibility = View.VISIBLE

        binding.souseBtn.visibility = View.VISIBLE
        binding.souseBck.visibility = View.VISIBLE
        binding.souseImg.visibility = View.VISIBLE
        binding.souseTxt.visibility = View.VISIBLE
        binding.difficultyLevelSouse1.visibility = View.VISIBLE
        binding.difficultyLevelSouse2.visibility = View.VISIBLE
        binding.difficultyLevelSouse3.visibility = View.VISIBLE
        binding.difficultySouse.visibility = View.VISIBLE

        binding.johnnyBreadBtn.visibility = View.VISIBLE
        binding.johnnyBreadBck.visibility = View.VISIBLE
        binding.johnnyBreadImg.visibility = View.VISIBLE
        binding.johnnyBreadTxt.visibility = View.VISIBLE
        binding.difficultyBread.visibility = View.VISIBLE
        binding.difficultyLevelBread1.visibility = View.VISIBLE
        binding.difficultyLevelBread2.visibility = View.VISIBLE

        binding.frittersBtn.visibility = View.VISIBLE
        binding.frittersBck.visibility = View.VISIBLE
        binding.frittersImg.visibility = View.VISIBLE
        binding.frittersTxt.visibility = View.VISIBLE
        binding.difficultyFritters.visibility = View.VISIBLE
        binding.difficultyLevelFritters1.visibility = View.VISIBLE

        binding.searchNotFound.visibility = View.GONE
    }


    fun showBreakfast() {
        binding.macaroniBck.visibility = View.GONE
        binding.difficultyMac.visibility = View.GONE
        binding.difficultyLevelMac.visibility = View.GONE
        binding.macaroniBtn.visibility = View.GONE
        binding.macaroniTxt.visibility = View.GONE
        binding.macaroniImg.visibility = View.GONE

        binding.riceImg.visibility = View.GONE
        binding.riceTxt.visibility = View.GONE
        binding.peasNRiceBtn.visibility = View.GONE
        binding.difficultyLevelRice1.visibility = View.GONE
        binding.difficultyLevelRice2.visibility = View.GONE
        binding.difficultyRice.visibility = View.GONE
        binding.peasNRiceBck.visibility = View.GONE

        binding.souseBtn.visibility = View.VISIBLE
        binding.souseBck.visibility = View.VISIBLE
        binding.souseImg.visibility = View.VISIBLE
        binding.souseTxt.visibility = View.VISIBLE
        binding.difficultyLevelSouse1.visibility = View.VISIBLE
        binding.difficultyLevelSouse2.visibility = View.VISIBLE
        binding.difficultyLevelSouse3.visibility = View.VISIBLE
        binding.difficultySouse.visibility = View.VISIBLE

        binding.johnnyBreadBtn.visibility = View.VISIBLE
        binding.johnnyBreadBck.visibility = View.VISIBLE
        binding.johnnyBreadImg.visibility = View.VISIBLE
        binding.johnnyBreadTxt.visibility = View.VISIBLE
        binding.difficultyBread.visibility = View.VISIBLE
        binding.difficultyLevelBread1.visibility = View.VISIBLE
        binding.difficultyLevelBread2.visibility = View.VISIBLE

        binding.frittersBtn.visibility = View.GONE
        binding.frittersBck.visibility = View.GONE
        binding.frittersImg.visibility = View.GONE
        binding.frittersTxt.visibility = View.GONE
        binding.difficultyFritters.visibility = View.GONE
        binding.difficultyLevelFritters1.visibility = View.GONE

        binding.searchNotFound.visibility = View.GONE
    }

    fun showLunchDinner() {
        binding.macaroniBck.visibility = View.GONE
        binding.difficultyMac.visibility = View.GONE
        binding.difficultyLevelMac.visibility = View.GONE
        binding.macaroniBtn.visibility = View.GONE
        binding.macaroniTxt.visibility = View.GONE
        binding.macaroniImg.visibility = View.GONE

        binding.riceImg.visibility = View.VISIBLE
        binding.riceTxt.visibility = View.VISIBLE
        binding.peasNRiceBtn.visibility = View.VISIBLE
        binding.difficultyLevelRice1.visibility = View.VISIBLE
        binding.difficultyLevelRice2.visibility = View.VISIBLE
        binding.difficultyRice.visibility = View.VISIBLE
        binding.peasNRiceBck.visibility = View.VISIBLE

        binding.souseBtn.visibility = View.GONE
        binding.souseBck.visibility = View.GONE
        binding.souseImg.visibility = View.GONE
        binding.souseTxt.visibility = View.GONE
        binding.difficultyLevelSouse1.visibility = View.GONE
        binding.difficultyLevelSouse2.visibility = View.GONE
        binding.difficultyLevelSouse3.visibility = View.GONE
        binding.difficultySouse.visibility = View.GONE

        binding.johnnyBreadBtn.visibility = View.GONE
        binding.johnnyBreadBck.visibility = View.GONE
        binding.johnnyBreadImg.visibility = View.GONE
        binding.johnnyBreadTxt.visibility = View.GONE
        binding.difficultyBread.visibility = View.GONE
        binding.difficultyLevelBread1.visibility = View.GONE
        binding.difficultyLevelBread2.visibility = View.GONE

        binding.frittersBtn.visibility = View.VISIBLE
        binding.frittersBck.visibility = View.VISIBLE
        binding.frittersImg.visibility = View.VISIBLE
        binding.frittersTxt.visibility = View.VISIBLE
        binding.difficultyFritters.visibility = View.VISIBLE
        binding.difficultyLevelFritters1.visibility = View.VISIBLE

        binding.searchNotFound.visibility = View.GONE
    }

    fun showSide() {
        binding.macaroniBck.visibility = View.VISIBLE
        binding.difficultyMac.visibility = View.VISIBLE
        binding.difficultyLevelMac.visibility = View.VISIBLE
        binding.macaroniBtn.visibility = View.VISIBLE
        binding.macaroniTxt.visibility = View.VISIBLE
        binding.macaroniImg.visibility = View.VISIBLE

        binding.riceImg.visibility = View.GONE
        binding.riceTxt.visibility = View.GONE
        binding.peasNRiceBtn.visibility = View.GONE
        binding.difficultyLevelRice1.visibility = View.GONE
        binding.difficultyLevelRice2.visibility = View.GONE
        binding.difficultyRice.visibility = View.GONE
        binding.peasNRiceBck.visibility = View.GONE

        binding.souseBtn.visibility = View.GONE
        binding.souseBck.visibility = View.GONE
        binding.souseImg.visibility = View.GONE
        binding.souseTxt.visibility = View.GONE
        binding.difficultyLevelSouse1.visibility = View.GONE
        binding.difficultyLevelSouse2.visibility = View.GONE
        binding.difficultyLevelSouse3.visibility = View.GONE
        binding.difficultySouse.visibility = View.GONE

        binding.johnnyBreadBtn.visibility = View.VISIBLE
        binding.johnnyBreadBck.visibility = View.VISIBLE
        binding.johnnyBreadImg.visibility = View.VISIBLE
        binding.johnnyBreadTxt.visibility = View.VISIBLE
        binding.difficultyBread.visibility = View.VISIBLE
        binding.difficultyLevelBread1.visibility = View.VISIBLE
        binding.difficultyLevelBread2.visibility = View.VISIBLE

        binding.frittersBtn.visibility = View.VISIBLE
        binding.frittersBck.visibility = View.VISIBLE
        binding.frittersImg.visibility = View.VISIBLE
        binding.frittersTxt.visibility = View.VISIBLE
        binding.difficultyFritters.visibility = View.VISIBLE
        binding.difficultyLevelFritters1.visibility = View.VISIBLE

        binding.searchNotFound.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun performSearch(query: String?) {
        if(query == "Macaroni" || query == "macaroni" || query == "mac") {
            //Make sure Macaroni is visible
            binding.macaroniBck.visibility = View.VISIBLE
            binding.difficultyMac.visibility = View.VISIBLE
            binding.difficultyLevelMac.visibility = View.VISIBLE
            binding.macaroniBtn.visibility = View.VISIBLE
            binding.macaroniTxt.visibility = View.VISIBLE
            binding.macaroniImg.visibility = View.VISIBLE

            //Hide Peas n' Rice
            binding.riceImg.visibility = View.GONE
            binding.riceTxt.visibility = View.GONE
            binding.peasNRiceBtn.visibility = View.GONE
            binding.difficultyLevelRice1.visibility = View.GONE
            binding.difficultyLevelRice2.visibility = View.GONE
            binding.difficultyRice.visibility = View.GONE
            binding.peasNRiceBck.visibility = View.GONE

            //Hide Chicken Souse
            binding.souseBtn.visibility = View.GONE
            binding.souseBck.visibility = View.GONE
            binding.souseImg.visibility = View.GONE
            binding.souseTxt.visibility = View.GONE
            binding.difficultyLevelSouse1.visibility = View.GONE
            binding.difficultyLevelSouse2.visibility = View.GONE
            binding.difficultyLevelSouse3.visibility = View.GONE
            binding.difficultySouse.visibility = View.GONE

            //Hide Johnny Bread
            binding.johnnyBreadBtn.visibility = View.GONE
            binding.johnnyBreadBck.visibility = View.GONE
            binding.johnnyBreadImg.visibility = View.GONE
            binding.johnnyBreadTxt.visibility = View.GONE
            binding.difficultyBread.visibility = View.GONE
            binding.difficultyLevelBread1.visibility = View.GONE
            binding.difficultyLevelBread2.visibility = View.GONE

            //Hide Conch Fritters
            binding.frittersBtn.visibility = View.GONE
            binding.frittersBck.visibility = View.GONE
            binding.frittersImg.visibility = View.GONE
            binding.frittersTxt.visibility = View.GONE
            binding.difficultyFritters.visibility = View.GONE
            binding.difficultyLevelFritters1.visibility = View.GONE

            binding.searchNotFound.visibility = View.GONE

        } else if(query == "rice" || query == "Rice" || query == "Peas" || query == "peas" ||
            query == "Peas n' rice" || query == "peas n' rice" || query == "Peas n' Rice" ||
            query == "Peas and rice" || query == "peas and rice") {
            //Make sure Peas n' Rice is visible
            binding.riceImg.visibility = View.VISIBLE
            binding.riceTxt.visibility = View.VISIBLE
            binding.peasNRiceBtn.visibility = View.VISIBLE
            binding.difficultyLevelRice1.visibility = View.VISIBLE
            binding.difficultyLevelRice2.visibility = View.VISIBLE
            binding.difficultyRice.visibility = View.VISIBLE
            binding.peasNRiceBck.visibility = View.VISIBLE

            //Hide Macaroni
            binding.macaroniBck.visibility = View.GONE
            binding.difficultyMac.visibility = View.GONE
            binding.difficultyLevelMac.visibility = View.GONE
            binding.macaroniBtn.visibility = View.GONE
            binding.macaroniTxt.visibility = View.GONE
            binding.macaroniImg.visibility = View.GONE

            //Hide Chicken Souse
            binding.souseBtn.visibility = View.GONE
            binding.souseBck.visibility = View.GONE
            binding.souseImg.visibility = View.GONE
            binding.souseTxt.visibility = View.GONE
            binding.difficultyLevelSouse1.visibility = View.GONE
            binding.difficultyLevelSouse2.visibility = View.GONE
            binding.difficultyLevelSouse3.visibility = View.GONE
            binding.difficultySouse.visibility = View.GONE

            //Hide Johnny Bread
            binding.johnnyBreadBtn.visibility = View.GONE
            binding.johnnyBreadBck.visibility = View.GONE
            binding.johnnyBreadImg.visibility = View.GONE
            binding.johnnyBreadTxt.visibility = View.GONE
            binding.difficultyBread.visibility = View.GONE
            binding.difficultyLevelBread1.visibility = View.GONE
            binding.difficultyLevelBread2.visibility = View.GONE

            //Hide Conch Fritters
            binding.frittersBtn.visibility = View.GONE
            binding.frittersBck.visibility = View.GONE
            binding.frittersImg.visibility = View.GONE
            binding.frittersTxt.visibility = View.GONE
            binding.difficultyFritters.visibility = View.GONE
            binding.difficultyLevelFritters1.visibility = View.GONE

            binding.searchNotFound.visibility = View.GONE

        } else if(query == "Chicken" || query == "chicken" || query == "souse" || query == "Chicken souse"
            || query == "Chicken Souse" || query == "Souse" || query == "chicken souse") {
            //Make sure Chicken Souse is visible
            binding.souseBtn.visibility = View.VISIBLE
            binding.souseBck.visibility = View.VISIBLE
            binding.souseImg.visibility = View.VISIBLE
            binding.souseTxt.visibility = View.VISIBLE
            binding.difficultyLevelSouse1.visibility = View.VISIBLE
            binding.difficultyLevelSouse2.visibility = View.VISIBLE
            binding.difficultyLevelSouse3.visibility = View.VISIBLE
            binding.difficultySouse.visibility = View.VISIBLE

            //Hide Macaroni
            binding.macaroniBck.visibility = View.GONE
            binding.difficultyMac.visibility = View.GONE
            binding.difficultyLevelMac.visibility = View.GONE
            binding.macaroniBtn.visibility = View.GONE
            binding.macaroniTxt.visibility = View.GONE
            binding.macaroniImg.visibility = View.GONE

            //Hide Peas n' Rice
            binding.riceImg.visibility = View.GONE
            binding.riceTxt.visibility = View.GONE
            binding.peasNRiceBtn.visibility = View.GONE
            binding.difficultyLevelRice1.visibility = View.GONE
            binding.difficultyLevelRice2.visibility = View.GONE
            binding.difficultyRice.visibility = View.GONE
            binding.peasNRiceBck.visibility = View.GONE

            //Hide Johnny Bread
            binding.johnnyBreadBtn.visibility = View.GONE
            binding.johnnyBreadBck.visibility = View.GONE
            binding.johnnyBreadImg.visibility = View.GONE
            binding.johnnyBreadTxt.visibility = View.GONE
            binding.difficultyBread.visibility = View.GONE
            binding.difficultyLevelBread1.visibility = View.GONE
            binding.difficultyLevelBread2.visibility = View.GONE

            //Hide Conch Fritters
            binding.frittersBtn.visibility = View.GONE
            binding.frittersBck.visibility = View.GONE
            binding.frittersImg.visibility = View.GONE
            binding.frittersTxt.visibility = View.GONE
            binding.difficultyFritters.visibility = View.GONE
            binding.difficultyLevelFritters1.visibility = View.GONE

            binding.searchNotFound.visibility = View.GONE

        } else if(query == "bread" || query == "Bread" || query == "Johnny" || query == "johnny" ||
            query == "Johnny Bread" || query == "Johnny bread" || query == "johnny bread") {
            //Make sure Johnny Bread is visible
            binding.johnnyBreadBtn.visibility = View.VISIBLE
            binding.johnnyBreadBck.visibility = View.VISIBLE
            binding.johnnyBreadImg.visibility = View.VISIBLE
            binding.johnnyBreadTxt.visibility = View.VISIBLE
            binding.difficultyBread.visibility = View.VISIBLE
            binding.difficultyLevelBread1.visibility = View.VISIBLE
            binding.difficultyLevelBread2.visibility = View.VISIBLE

            //Hide Macaroni
            binding.macaroniBck.visibility = View.GONE
            binding.difficultyMac.visibility = View.GONE
            binding.difficultyLevelMac.visibility = View.GONE
            binding.macaroniBtn.visibility = View.GONE
            binding.macaroniTxt.visibility = View.GONE
            binding.macaroniImg.visibility = View.GONE

            //Hide Peas n' Rice
            binding.riceImg.visibility = View.GONE
            binding.riceTxt.visibility = View.GONE
            binding.peasNRiceBtn.visibility = View.GONE
            binding.difficultyLevelRice1.visibility = View.GONE
            binding.difficultyLevelRice2.visibility = View.GONE
            binding.difficultyRice.visibility = View.GONE
            binding.peasNRiceBck.visibility = View.GONE

            //Hide Chicken Souse
            binding.souseBtn.visibility = View.GONE
            binding.souseBck.visibility = View.GONE
            binding.souseImg.visibility = View.GONE
            binding.souseTxt.visibility = View.GONE
            binding.difficultyLevelSouse1.visibility = View.GONE
            binding.difficultyLevelSouse2.visibility = View.GONE
            binding.difficultyLevelSouse3.visibility = View.GONE
            binding.difficultySouse.visibility = View.GONE

            //Hide Conch Fritters
            binding.frittersBtn.visibility = View.GONE
            binding.frittersBck.visibility = View.GONE
            binding.frittersImg.visibility = View.GONE
            binding.frittersTxt.visibility = View.GONE
            binding.difficultyFritters.visibility = View.GONE
            binding.difficultyLevelFritters1.visibility = View.GONE

            binding.searchNotFound.visibility = View.GONE

        } else if(query == "fritters" || query == "Fritters" || query == "Conch" || query == "conch"
            || query == "conch fritters" || query == "Conch fritters") {
            // Make sure Conch Fritters is visible
            binding.frittersBtn.visibility = View.VISIBLE
            binding.frittersBck.visibility = View.VISIBLE
            binding.frittersImg.visibility = View.VISIBLE
            binding.frittersTxt.visibility = View.VISIBLE
            binding.difficultyFritters.visibility = View.VISIBLE
            binding.difficultyLevelFritters1.visibility = View.VISIBLE

            //Hide Macaroni
            binding.macaroniBck.visibility = View.GONE
            binding.difficultyMac.visibility = View.GONE
            binding.difficultyLevelMac.visibility = View.GONE
            binding.macaroniBtn.visibility = View.GONE
            binding.macaroniTxt.visibility = View.GONE
            binding.macaroniImg.visibility = View.GONE

            //Hide Peas n' Rice
            binding.riceImg.visibility = View.GONE
            binding.riceTxt.visibility = View.GONE
            binding.peasNRiceBtn.visibility = View.GONE
            binding.difficultyLevelRice1.visibility = View.GONE
            binding.difficultyLevelRice2.visibility = View.GONE
            binding.difficultyRice.visibility = View.GONE
            binding.peasNRiceBck.visibility = View.GONE

            //Hide Chicken Souse
            binding.souseBtn.visibility = View.GONE
            binding.souseBck.visibility = View.GONE
            binding.souseImg.visibility = View.GONE
            binding.souseTxt.visibility = View.GONE
            binding.difficultyLevelSouse1.visibility = View.GONE
            binding.difficultyLevelSouse2.visibility = View.GONE
            binding.difficultyLevelSouse3.visibility = View.GONE
            binding.difficultySouse.visibility = View.GONE

            //Hide Johnny Bread
            binding.johnnyBreadBtn.visibility = View.GONE
            binding.johnnyBreadBck.visibility = View.GONE
            binding.johnnyBreadImg.visibility = View.GONE
            binding.johnnyBreadTxt.visibility = View.GONE
            binding.difficultyBread.visibility = View.GONE
            binding.difficultyLevelBread1.visibility = View.GONE
            binding.difficultyLevelBread2.visibility = View.GONE

            binding.searchNotFound.visibility = View.GONE

        } else {
            if(query != " ") {
                binding.searchNotFound.text = "Sorry, search for $query not found."
                binding.searchNotFound.visibility = View.VISIBLE

                binding.macaroniBck.visibility = View.GONE
                binding.difficultyMac.visibility = View.GONE
                binding.difficultyLevelMac.visibility = View.GONE
                binding.macaroniBtn.visibility = View.GONE
                binding.macaroniTxt.visibility = View.GONE
                binding.macaroniImg.visibility = View.GONE

                binding.riceImg.visibility = View.GONE
                binding.riceTxt.visibility = View.GONE
                binding.peasNRiceBtn.visibility = View.GONE
                binding.difficultyLevelRice1.visibility = View.GONE
                binding.difficultyLevelRice2.visibility = View.GONE
                binding.difficultyRice.visibility = View.GONE
                binding.peasNRiceBck.visibility = View.GONE

                binding.souseBtn.visibility = View.GONE
                binding.souseBck.visibility = View.GONE
                binding.souseImg.visibility = View.GONE
                binding.souseTxt.visibility = View.GONE
                binding.difficultyLevelSouse1.visibility = View.GONE
                binding.difficultyLevelSouse2.visibility = View.GONE
                binding.difficultyLevelSouse3.visibility = View.GONE
                binding.difficultySouse.visibility = View.GONE

                binding.johnnyBreadBtn.visibility = View.GONE
                binding.johnnyBreadBck.visibility = View.GONE
                binding.johnnyBreadImg.visibility = View.GONE
                binding.johnnyBreadTxt.visibility = View.GONE
                binding.difficultyBread.visibility = View.GONE
                binding.difficultyLevelBread1.visibility = View.GONE
                binding.difficultyLevelBread2.visibility = View.GONE

                binding.frittersBtn.visibility = View.GONE
                binding.frittersBck.visibility = View.GONE
                binding.frittersImg.visibility = View.GONE
                binding.frittersTxt.visibility = View.GONE
                binding.difficultyFritters.visibility = View.GONE
                binding.difficultyLevelFritters1.visibility = View.GONE
            } else {
                binding.macaroniBck.visibility = View.VISIBLE
                binding.difficultyMac.visibility = View.VISIBLE
                binding.difficultyLevelMac.visibility = View.VISIBLE
                binding.macaroniBtn.visibility = View.VISIBLE
                binding.macaroniTxt.visibility = View.VISIBLE
                binding.macaroniImg.visibility = View.VISIBLE

                binding.riceImg.visibility = View.VISIBLE
                binding.riceTxt.visibility = View.VISIBLE
                binding.peasNRiceBtn.visibility = View.VISIBLE
                binding.difficultyLevelRice1.visibility = View.VISIBLE
                binding.difficultyLevelRice2.visibility = View.VISIBLE
                binding.difficultyRice.visibility = View.VISIBLE
                binding.peasNRiceBck.visibility = View.VISIBLE

                binding.souseBtn.visibility = View.VISIBLE
                binding.souseBck.visibility = View.VISIBLE
                binding.souseImg.visibility = View.VISIBLE
                binding.souseTxt.visibility = View.VISIBLE
                binding.difficultyLevelSouse1.visibility = View.VISIBLE
                binding.difficultyLevelSouse2.visibility = View.VISIBLE
                binding.difficultyLevelSouse3.visibility = View.VISIBLE
                binding.difficultySouse.visibility = View.VISIBLE

                binding.johnnyBreadBtn.visibility = View.VISIBLE
                binding.johnnyBreadBck.visibility = View.VISIBLE
                binding.johnnyBreadImg.visibility = View.VISIBLE
                binding.johnnyBreadTxt.visibility = View.VISIBLE
                binding.difficultyBread.visibility = View.VISIBLE
                binding.difficultyLevelBread1.visibility = View.VISIBLE
                binding.difficultyLevelBread2.visibility = View.VISIBLE

                binding.frittersBtn.visibility = View.VISIBLE
                binding.frittersBck.visibility = View.VISIBLE
                binding.frittersImg.visibility = View.VISIBLE
                binding.frittersTxt.visibility = View.VISIBLE
                binding.difficultyFritters.visibility = View.VISIBLE
                binding.difficultyLevelFritters1.visibility = View.VISIBLE
            }



        }


    }

}