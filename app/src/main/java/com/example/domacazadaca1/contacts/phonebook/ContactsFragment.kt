package com.example.domacazadaca1.contacts.phonebook

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domacazadaca1.R
import com.example.domacazadaca1.SharedContactViewModel
import com.example.domacazadaca1.contacts.adapters.RecycleAdapter
import com.example.domacazadaca1.databinding.FragmentContactsBinding
import com.google.android.material.snackbar.Snackbar

class ContactsFragment : Fragment(), RecycleAdapter.OnItemClickListener {

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


        if (!sharedViewModel.contacts.value.isNullOrEmpty()) {

            binding.contactsText.visibility = View.GONE
            
            binding.recyclerView.adapter =
                RecycleAdapter(
                    sharedViewModel.contacts, this
                )
            binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
            binding.recyclerView.setHasFixedSize(true)

            //setting Snackbar
            Snackbar.make(binding.root, getString(R.string.snackbar_info), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbar_confirmation)) {
                    // Responds to click on the action
                }
                .show()

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
//        val intent = Intent(context, RecyclerItemActivity::class.java)
//        startActivity(intent)
    }

}