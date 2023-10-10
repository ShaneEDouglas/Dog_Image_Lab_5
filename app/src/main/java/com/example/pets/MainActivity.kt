package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pets.petViewmodel.PetViewModel

private lateinit var  viewmodel: PetViewModel
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this)[PetViewModel::class.java]

        val petimage = findViewById<ImageView>(R.id.petimage)
        val petbtn = findViewById<AppCompatButton>(R.id.randompetbutton)

        viewmodel.dogImageUrl.observe(this) { url ->
            Glide.with(this)
                .load(url)
                .into(petimage)
        }

        petbtn.setOnClickListener {
            viewmodel.GetDogImageURl()
        }

    }
}