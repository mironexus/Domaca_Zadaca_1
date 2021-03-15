package com.example.domacazadaca1

import androidx.lifecycle.ViewModel

class SharedContactViewModel: ViewModel() {

    var contactMutableList = mutableListOf<Contact>()

    fun addContact(name: String, surname: String, age: Int, faculty: String, oib: Long) {
        contactMutableList.add(Contact(name, surname, age, faculty, oib))
    }

}