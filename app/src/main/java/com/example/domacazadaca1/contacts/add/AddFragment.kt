package com.example.domacazadaca1.contacts.add

import android.os.Bundle
import android.text.InputFilter
import android.text.InputType.TYPE_CLASS_NUMBER
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.domacazadaca1.models.Contact
import com.example.domacazadaca1.R
import com.example.domacazadaca1.SharedContactViewModel
import com.example.domacazadaca1.databinding.FragmentAddBinding
import com.example.domacazadaca1.models.Country
import kotlinx.android.synthetic.main.input_edittext.view.*

class AddFragment : Fragment() {

    //FragmentAddBinding gets name from fragment's xml name
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.add)
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        //spinner set up
        var countrySpinner = binding.countrySpinner

            val adapter = this.context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item, Country.values()
                )
            }
        countrySpinner.adapter = adapter

        var defaultImageUri = getString(R.string.default_image)

        //button onclick
        binding.addButton.setOnClickListener {

            //check if input in EditTexts is empty
            if(binding.name.getText() == "" || binding.surname.getText() == "" || binding.age.getText() == ""   || binding.faculty.getText() == "" || binding.oib.getText() == ""){
                Toast.makeText(activity, getString(R.string.empty_info), Toast.LENGTH_LONG).show()
            }
            else if(binding.age.getInteger() < 0 || binding.age.getInteger() >= 120){
                Toast.makeText(activity, getString(R.string.age_limit_info), Toast.LENGTH_LONG).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.getText()).matches()) {
                Toast.makeText(activity, getString(R.string.email_info), Toast.LENGTH_LONG).show()
            }
            else if(binding.oib.getLong() < 0) {
                Toast.makeText(activity, getString(R.string.oib_limit_info), Toast.LENGTH_LONG).show()
            }
            //send the input to the viewmodel
            else {

                var newContact = Contact(
                    defaultImageUri,
                    binding.phoneNumber.getText(),
                    binding.name.getText(),
                    binding.surname.getText(),
                    binding.age.getInteger(),
                    binding.email.getText(),
                    binding.faculty.getText(),
                    binding.oib.getLong(),
                    if(binding.radioMale.isChecked) getString(R.string.male) else getString(R.string.female),
                    binding.countrySpinner.selectedItem.toString(),
                    binding.checkboxFavorite.isChecked
                )

                sharedViewModel.contacts.observe(viewLifecycleOwner, Observer {
                    sharedViewModel.addContact(newContact)
                })

                binding.phoneNumber.clear()
                binding.name.clear()
                binding.surname.clear()
                binding.age.clear()
                binding.email.clear()
                binding.faculty.clear()
                binding.oib.clear()

            }

        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

