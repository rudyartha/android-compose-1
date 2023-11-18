package com.pnb.myapplication.models

data class Greeting(val title: String, val description: String)


object Greetings {
    val listOfGreeting = listOf(
        Greeting("Hello, Good Morning", "Greeting from USA"),
        Greeting("Halo, Selamat Pagi", "Salam dari Indonesia"),
        Greeting("Guten Morgen!", "Greeting from German"),
        Greeting("Rahajeng Semeng!", "Salam dari Bali"),
    )
}


