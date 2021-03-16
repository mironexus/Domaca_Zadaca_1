package com.example.domacazadaca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.domacazadaca1.contacts.add.AddFragment
import com.example.domacazadaca1.contacts.phonebook.ContactsFragment
import com.example.domacazadaca1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addFragment = AddFragment()
        val contactsFragment =
            ContactsFragment()

        //sets default fragment
        setFragment(addFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.add -> setFragment(addFragment)
                R.id.contacts -> setFragment(contactsFragment)
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_container, fragment)
            commit()
        }
    }

}