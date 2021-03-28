package com.example.domacazadaca1.contacts.settings

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.domacazadaca1.R
import com.example.domacazadaca1.databinding.FragmentSettingsBinding
import java.util.*


enum class Languages(val code: String) {
    English("en_"),
    Croatian("hr_HR");

    override fun toString() : String {
        return code
    }
}

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        requireActivity().window.statusBarColor = resources.getColor(R.color.colorAccent)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //loadLocale()
        activity?.title = getString(R.string.settings)
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        //spinner set up
        var countrySpinner = binding.languageSpinner

        val adapter = this.context?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_item, Languages.values())
        }
        countrySpinner.adapter = adapter

        binding.languageButton.setOnClickListener {
            var countryCode = binding.languageSpinner.selectedItem.toString()
            Toast.makeText(activity, "$countryCode", Toast.LENGTH_LONG).show()

            activity?.applicationContext?.let { it1 -> LocaleHelper.setLocale(it1, "$countryCode") }?.resources

            binding.languageLabel.text = getString(R.string.label_phone_number)
        }

        return view
    }

}