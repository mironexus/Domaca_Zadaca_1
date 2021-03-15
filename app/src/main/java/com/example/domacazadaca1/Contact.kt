package com.example.domacazadaca1

data class Contact (val name: String, val surname: String, val age: Int, val faculty: String, val oib: Long) {
    override fun toString(): String = "$name $surname, $age, $faculty, $oib"
}