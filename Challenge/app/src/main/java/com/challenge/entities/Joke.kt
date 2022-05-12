package com.challenge.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*
@Entity(tableName = "jokes")
class Joke (
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("source")
    val source: String,

    @SerializedName("jokeId")
    val jokeId: Long,

    @SerializedName("content")
    val content: String,

    @SerializedName("rating")
    var rating: Float,
    /*
    @SerializedName("createdAt")
    val createdAt: Date,
    */
)