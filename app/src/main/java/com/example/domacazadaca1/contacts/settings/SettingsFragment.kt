package com.example.domacazadaca1.contacts.settings

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import com.example.domacazadaca1.MainActivity
import com.example.domacazadaca1.R
import com.example.domacazadaca1.contacts.phonebook.RecyclerItemActivity
import com.example.domacazadaca1.databinding.ActivityMainBinding
import com.example.domacazadaca1.databinding.FragmentAddBinding
import com.example.domacazadaca1.databinding.FragmentSettingsBinding
import com.example.domacazadaca1.models.Country
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.add)
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        //spinner set up
        var countrySpinner = binding.languageSpinner

        val adapter = this.context?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_item, Languages.values())
        }
        countrySpinner.adapter = adapter

        binding.languageButton.setOnClickListener {
//            var countryCode = binding.languageSpinner.selectedItem.toString()
//            Toast.makeText(activity, "$countryCode", Toast.LENGTH_LONG).show()
//            activity?.let { setLocale(it, countryCode) }
            //setLocale("hr_HR")
//            context?.let { it1 -> LocaleHelper.setLocale(it1, "hr_rHR") };
//            binding.languageButton.text = resources.getString(R.string.change);
            val intent = Intent(context, RecyclerItemActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun setLocale(languageCode: String?) {
        val locale = Locale("hr_HR")
        Locale.setDefault(locale)
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        activity?.recreate()
    }

}