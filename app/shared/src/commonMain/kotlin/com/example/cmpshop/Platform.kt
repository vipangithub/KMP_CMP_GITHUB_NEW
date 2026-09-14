package com.example.cmpshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform