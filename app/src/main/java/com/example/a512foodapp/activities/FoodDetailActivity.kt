package com.example.a512foodapp.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a512foodapp.R
import com.example.a512foodapp.models.Food
import com.squareup.picasso.Picasso

class FoodDetailActivity : AppCompatActivity() {
    lateinit var foodTextView: TextView
    lateinit var foodPriceTextView: TextView
    lateinit var foodDecriptionTextView: TextView
    lateinit var foodImageView: ImageView
    lateinit var foodRatingTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_detail)
        foodTextView = findViewById(R.id.food_title)
        foodImageView = findViewById(R.id.food_image)
        foodPriceTextView = findViewById(R.id.food_price)
        foodDecriptionTextView = findViewById(R.id.food_description)
        foodRatingTextView = findViewById(R.id.food_rating)
        val foodId = intent.getIntExtra("foodId",0)

        val food = Food.foods.firstOrNull { food: Food ->
            food.id == foodId
        }

        foodTextView.text = food?.name
        foodPriceTextView.text = food?.computedPrice
        foodRatingTextView.text = food?.rating.toString()
        Picasso.get().load(food?.image).into(foodImageView)
        foodDecriptionTextView.text = food?.description
    }
}