package com.example.a512foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a512foodapp.R
import com.example.a512foodapp.models.Food
import com.squareup.picasso.Picasso

class FoodAdapter(val foodList : List<Food>, val onClick : (Food)->Unit) : RecyclerView.Adapter<FoodViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.count()
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodName.text = food.name
        holder.foodPrice.text = food.computedPrice
        holder.foodRating.text = food.rating.toString()
        Picasso.get().load(food.image).into(holder.foodImage)
        holder.itemView.setOnClickListener {
            onClick(food)
        }
    }

}

class FoodViewHolder(view:View): ViewHolder(view){
    val foodImage : ImageView = view.findViewById(R.id.food_image)
    val foodName : TextView = view.findViewById(R.id.food_name)
    val foodPrice : TextView = view.findViewById(R.id.food_price)
    val foodRating : TextView = view.findViewById(R.id.food_rating)
}