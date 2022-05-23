package com.example.hw1a2

import java.io.Serializable

data class News(
    val title:String,
    val createdAt:Long,
) :Serializable
