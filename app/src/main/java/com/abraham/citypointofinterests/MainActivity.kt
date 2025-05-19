package com.abraham.citypointofinterests

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.abraham.citypointofinterests.databinding.ActivityMainBinding
import com.abraham.citypointofinterests.domain.Landmark

class MainActivity : AppCompatActivity() {
    private lateinit var landmarkList:List<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // Data
        val pisa = Landmark("Pisa Tower", "Italy", R.drawable.pisa)
        val eiffel = Landmark("Eiffel Tower", "France", R.drawable.eiffel)
        val koln = Landmark("Cologne Cathetral", "Germany", R.drawable.koln)
        val liberty = Landmark("Liberty Tower", "USA", R.drawable.liberty)

        landmarkList = listOf<Landmark>(pisa,eiffel,koln,liberty)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        val landmarkAdaptor = LandmarkAdaptor(landmarkList)
        binding.recycleView.adapter = landmarkAdaptor
       /*
        // Adaptor : Make connection between Layout and Data
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, landmarkList.map {
            it -> it.name
        })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }
         */
    }


}