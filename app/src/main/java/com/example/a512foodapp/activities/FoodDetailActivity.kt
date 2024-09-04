package com.example.a512foodapp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a512foodapp.R
import com.example.a512foodapp.models.Food

class FoodDetailActivity : AppCompatActivity() {
    lateinit var foodTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_detail)
        foodTextView = findViewById(R.id.food_title)
        val foodId = intent.getIntExtra("foodId",0)

        val food = Food.foods.firstOrNull { food: Food ->
            food.id == foodId
        }

        foodTextView.text = food?.name
    }
}