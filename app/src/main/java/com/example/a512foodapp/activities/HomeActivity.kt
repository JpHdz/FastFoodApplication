package com.example.a512foodapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.a512foodapp.MainActivity
import com.example.a512foodapp.R
import com.example.a512foodapp.adapters.CategoryAdapter
import com.example.a512foodapp.adapters.FoodAdapter
import com.example.a512foodapp.adapters.RestaurantAdapter
import com.example.a512foodapp.models.Category
import com.example.a512foodapp.models.Food
import com.example.a512foodapp.models.Restaurant
import com.example.a512foodapp.models.User

class HomeActivity : AppCompatActivity() {
    lateinit var usernameTV : TextView
    lateinit var logoutBtn : ImageView
    lateinit var categoryRecyclerView : RecyclerView
    lateinit var restaurantRecyclerView: RecyclerView
    lateinit var foodRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        usernameTV = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
        categoryRecyclerView = findViewById(R.id.category_recycleview)
        restaurantRecyclerView = findViewById(R.id.restaurants_recyclerview)
        foodRecyclerView = findViewById(R.id.best_food_recycleview)
        categoryRecyclerView.adapter = CategoryAdapter(Category.categories)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        restaurantRecyclerView.adapter = RestaurantAdapter(Restaurant.restaurants)
        restaurantRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        foodRecyclerView.adapter = FoodAdapter(Food.foods)
        foodRecyclerView.layoutManager = GridLayoutManager(this,2)

        val user = User.users[1]
        usernameTV.text = user.computedName
        logoutBtn.setOnClickListener {
            Log.i("LOGOUT","Cerrando sesion")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@HomeActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}