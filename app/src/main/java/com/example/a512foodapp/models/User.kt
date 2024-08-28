package com.example.a512foodapp.models

data class User(val name:String,val email:String,val password: String){
    val computedName :String get() = "Hola, $name"
    companion object{
        val users = listOf(
            User("Juan","juanfr97@hotmail.com","12345"),
            User("Daniel","daniel98@hotmail.com","12345"),
            User("Andrea","andrea99@hotmail.com","12345")
        )
    }
}
