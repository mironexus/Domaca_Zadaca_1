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

        //initialize labels and hints
        setInputStrings()

        //spinner set up
        var countrySpinner = binding.countrySpinner

            val adapter = this.context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item, Country.values()
                )
            }
        countrySpinner.adapter = adapter

        //button onclick
        binding.addButton.setOnClickListener {

            //get views
//            var phoneNumber = binding.phoneNumber.input.text
            var name = binding.name.input.text
            var surname = binding.surname.input.text
            var age = binding.age.input.text
            var email = binding.email.input.text
            var faculty = binding.faculty.input.text
            var oib = binding.oib.input.text
            var gender = if(binding.radioMale.isChecked) getString(R.string.male) else getString(R.string.female)
            var country = binding.countrySpinner.selectedItem.toString()
            var favorite = binding.checkboxFavorite.isChecked


            //check if input in EditTexts is empty
            if(name.toString() == "" || surname.toString() == "" || age.toString() == ""   || faculty.toString() == "" || oib.toString() == ""){
                Toast.makeText(activity, getString(R.string.empty_info), Toast.LENGTH_LONG).show()
            }
            else if(age.toString().toInt() < 0 || age.toString().toInt() >= 120){
                Toast.makeText(activity, getString(R.string.age_limit_info), Toast.LENGTH_LONG).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
                Toast.makeText(activity, getString(R.string.email_info), Toast.LENGTH_LONG).show()
            }
            else if(oib.toString().toLong() < 0) {
                Toast.makeText(activity, getString(R.string.oib_limit_info), Toast.LENGTH_LONG).show()
            }
            //send the input to the viewmodel
            else {

                var newContact = Contact(
                    "",
                    name.toString(),
                    surname.toString(),
                    age.toString().toInt(),
                    email.toString(),
                    faculty.toString(),
                    oib.toString().toLong(),
                    gender,
                    country,
                    favorite
                )

                sharedViewModel.contacts.observe(viewLifecycleOwner, Observer {
                    sharedViewModel.addContact(newContact)
                })

//                phoneNumber.clear()
                name.clear()
                surname.clear()
                age.clear()
                email.clear()
                faculty.clear()
                oib.clear()

            }

        }
        return view
    }

    private fun setInputStrings() {
        //set types and limits of number EditTexts
//        binding.phoneNumber.input.inputType = TYPE_CLASS_NUMBER
//        binding.phoneNumber.input.filters += InputFilter.LengthFilter(10)
        binding.age.input.inputType = TYPE_CLASS_NUMBER
        binding.age.input.filters += InputFilter.LengthFilter(3)
        binding.oib.input.inputType = TYPE_CLASS_NUMBER
        binding.oib.input.filters += InputFilter.LengthFilter(13)
        //labels and hints of EditTexts
//        binding.phoneNumber.label.text = getString(R.string.label_phone_number)
//        binding.phoneNumber.input.hint = getString(R.string.phone_number_hint)
        binding.name.label.text = getString(R.string.label_name)
        binding.name.input.hint = getString(R.string.name_hint)
        binding.surname.label.text = getString(R.string.label_surname)
        binding.surname.input.hint = getString(R.string.surname_hint)
        binding.age.label.text = getString(R.string.label_age)
        binding.age.input.hint = getString(R.string.age_hint)
        binding.email.label.text = getString(R.string.label_email)
        binding.email.input.hint = getString(R.string.email_hint)
        binding.faculty.label.text = getString(R.string.label_faculty)
        binding.faculty.input.hint = getString(R.string.faculty_hint)
        binding.oib.label.text = getString(R.string.label_oib)
        binding.oib.input.hint = getString(R.string.oib_hint)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

