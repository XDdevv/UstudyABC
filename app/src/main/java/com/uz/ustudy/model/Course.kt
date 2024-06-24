package com.uz.ustudy.model

import uz.ustudy.model.CategoryDTO

data class Course(
    val id:Int,
    val name:String,
    val description:String,
    val category:List<CategoryDTO>,
    val timestamp:Long,
    val courseBanner: String,
    val introVideo: String,
    val isFree: Boolean,
    val price: Double? = null
)
