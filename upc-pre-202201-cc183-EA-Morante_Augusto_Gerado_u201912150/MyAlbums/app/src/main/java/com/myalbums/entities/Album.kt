package com.myalbums.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "albums")
class Album (
        @SerializedName("userId")
        val userId: Int,
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String
)