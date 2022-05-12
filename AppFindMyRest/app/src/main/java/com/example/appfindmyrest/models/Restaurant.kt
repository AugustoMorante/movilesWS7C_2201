package com.example.appfindmyrest.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "restaurants"
)
class Restaurant (
    @PrimaryKey
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("district")
    val district:String,

    @SerializedName("latitude")
    val latitude:Float,

    @SerializedName("longitude")
    val longitude:Float,

    @SerializedName("poster")
    val poster:String,

    @SerializedName("rating")
    val rating:Float
):Serializable