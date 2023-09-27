package com.example.submissionsmyfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionsmyfoods.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        list.addAll(getListFoods())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFoods.layoutManager = LinearLayoutManager(this)
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFoods(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataContext = resources.getStringArray(R.array.data_context)
        val dataRecipe = resources.getStringArray(R.array.data_recipe)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFoods = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataContext[i], dataDescription[i], dataRecipe[i], dataPhoto.getResourceId(i, -1))
            listFoods.add(food)
        }
        return listFoods
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFoods.adapter = listFoodAdapter

//        ListFoodAdapter.setOnItemCallBack(object : ListFoodAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Food) {
//                showSelectedFood(data)
//            }
//        })
    }

    private fun showSelectedFood(food: Food) {
        Toast.makeText(this, "Telah Memilih " + food.name, Toast.LENGTH_SHORT).show()
    }
}