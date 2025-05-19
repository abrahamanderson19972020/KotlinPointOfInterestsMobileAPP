package com.abraham.citypointofinterests

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abraham.citypointofinterests.databinding.RecycleRowBinding
import com.abraham.citypointofinterests.domain.Landmark

class LandmarkAdaptor(val landmarkList:List<Landmark>): RecyclerView.Adapter<LandmarkHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecycleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {
        return  landmarkList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
          holder.binding.recycleViewTextView.text = landmarkList.get(position).name
          holder.itemView.setOnClickListener {
              val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
              intent.putExtra("landmark", landmarkList.get(position))
              holder.itemView.context.startActivity(intent)
          }
    }
}

