package id.ac.ubaya.informatika.a160718012_midtermproject.model

import com.google.gson.annotations.SerializedName

data class Book(
    val id:Int,
    val title:String,
    val author:String?,
    val cover_url:String?,
    var totalPage:Int,
    var readPage:Int,
    val rate:Double,
    val language:String,
    val description:String
)

data class Quote(
    val title:String,
    val author:String?,
    val cover_url:String?,
    val quote:String
)