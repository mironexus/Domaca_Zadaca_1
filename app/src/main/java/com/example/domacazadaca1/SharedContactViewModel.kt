package com.example.domacazadaca1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domacazadaca1.models.Contact

class SharedContactViewModel: ViewModel() {

    var contacts = MutableLiveData<ArrayList<Contact>>()

    init {
        contacts.value = arrayListOf()
    }

    fun addContact(contact: Contact) {
        contacts.value?.add(contact)
    }

}