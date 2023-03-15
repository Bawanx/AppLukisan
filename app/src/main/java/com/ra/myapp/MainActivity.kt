package com.ra.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLukisan: RecyclerView
    private val list = ArrayList<Lukisan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLukisan = findViewById(R.id.rv_lukisan)
        rvLukisan.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvLukisan.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvLukisan.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Lukisan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.lukisan_price)
        val dataOrigin = resources.getStringArray(R.array.lukisan_origin)
        val listLukisan = ArrayList<Lukisan>()
        for (i in dataName.indices) {
            val lukisan = Lukisan(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPrice[i], dataOrigin[i])
            listLukisan.add(lukisan)
        }
        return listLukisan
    }

    private fun showRecyclerList() {
        rvLukisan.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListLukisanAdapter(list)
        rvLukisan.adapter = listHeroAdapter
    }
}