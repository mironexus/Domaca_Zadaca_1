package com.example.domacazadaca1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domacazadaca1.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = getString(R.string.contacts)
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val view = binding.root


        if (!sharedViewModel.contactMutableList.isNullOrEmpty()) {
            binding.contactsText.text = getString(R.string.contacts)

            binding.recyclerView.adapter = RecycleAdapter(sharedViewModel.contactMutableList)
            binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
            binding.recyclerView.setHasFixedSize(true)

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}