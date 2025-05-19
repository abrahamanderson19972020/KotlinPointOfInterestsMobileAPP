package com.abraham.citypointofinterests

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abraham.citypointofinterests.databinding.ActivityDetailsBinding
import com.abraham.citypointofinterests.databinding.ActivityMainBinding
import com.abraham.citypointofinterests.domain.Landmark

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
       val selectedLandmark =  intent.getSerializableExtra("landmark") as Landmark
       binding.textName.text = selectedLandmark.name
        binding.textCountry.text = selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)
    }
}