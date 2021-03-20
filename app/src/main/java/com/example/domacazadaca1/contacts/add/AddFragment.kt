package com.example.domacazadaca1.contacts.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.domacazadaca1.models.Contact
import com.example.domacazadaca1.R
import com.example.domacazadaca1.SharedContactViewModel
import com.example.domacazadaca1.databinding.FragmentAddBinding

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

        binding.addButton.setOnClickListener {

            //get views
            var name = binding.name.text
            var surname = binding.surname.text
            var age = binding.age.text
            var faculty = binding.faculty.text
            var oib = binding.oib.text

            //check if input in EditTexts is empty
            if(name.toString() == "" || surname.toString() == "" || age.toString() == ""   || faculty.toString() == "" || oib.toString() == ""){
                Toast.makeText(activity, getString(R.string.empty_info), Toast.LENGTH_LONG).show()
            }
            //send the input to the viewmodel
            else {

                var newContact = Contact(
                    name.toString(),
                    surname.toString(),
                    age.toString().toInt(),
                    faculty.toString(),
                    oib.toString().toLong()
                )

                sharedViewModel.contacts.observe(viewLifecycleOwner, Observer {
                    sharedViewModel.addContact(newContact)
                })

                name.clear()
                surname.clear()
                faculty.clear()
                age.clear()
                oib.clear()

            }

        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

