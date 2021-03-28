package com.example.domacazadaca1.models

data class Contact (val imageUri: String,
                    val phoneNumber: String,
                    val name: String,
                    val surname: String,
                    val age: Int,
                    val email: String,
                    val faculty: String,
                    val oib: Long,
                    val gender: String,
                    val country: String,
                    val favorite: Boolean) {
    override fun toString(): String = "$name $surname, $age, $faculty, $oib"
}