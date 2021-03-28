package com.example.domacazadaca1.contacts.phonebook

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.domacazadaca1.R
import com.example.domacazadaca1.databinding.ActivityRecyclerItemBinding
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_recycler_item.view.*


private lateinit var binding: ActivityRecyclerItemBinding

class RecyclerItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting Toolbar image (image) and profile picture (imageView)
        if (intent.getBooleanExtra("favorite", false))  {
            binding.image.load(R.drawable.ic_baseline_star_24)
            binding.imageView.load(R.drawable.ic_baseline_star_24)
        }
        else {
            binding.image.load(intent.getStringExtra("imageUri"))
            binding.imageView.load(intent.getStringExtra("imageUri")) {
                transformations(RoundedCornersTransformation(100f))
            }
        }

        //setting title of the Toolbar
        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        binding.collapsingToolbar.title = "$name $surname"

        //setting other information
        binding.phoneNumber.infoLabel.text = getString(R.string.label_phone_number)
        binding.phoneNumber.infoDetail.text = intent.getStringExtra("phoneNumber")

        binding.age.infoLabel.text = getString(R.string.label_age)
        val age =  intent.getIntExtra("age", 0)
        binding.age.infoDetail.text = String.format(age.toString())

        binding.email.infoLabel.text = getString(R.string.label_email)
        binding.email.infoDetail.text = intent.getStringExtra("email")

        binding.faculty.infoLabel.text = getString(R.string.label_faculty)
        binding.faculty.infoDetail.text = intent.getStringExtra("faculty")

        binding.oib.infoLabel.text = getString(R.string.label_oib)
        val oib =  intent.getLongExtra("oib", 0)
        binding.oib.infoDetail.text = String.format(oib.toString())

        binding.gender.infoLabel.text = getString(R.string.gender)
        binding.gender.infoDetail.text = intent.getStringExtra("gender")

        binding.country.infoLabel.text = getString(R.string.country)
        binding.country.infoDetail.text = intent.getStringExtra("country")

        //setting Snackbar
        Snackbar.make(binding.root, getString(R.string.snackbar_info), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.snackbar_confirmation)) {
                // Responds to click on the action
            }
            .show()


    }
}