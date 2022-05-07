package com.example.assessmentapplication.util

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Contact(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phone: String = ""
)