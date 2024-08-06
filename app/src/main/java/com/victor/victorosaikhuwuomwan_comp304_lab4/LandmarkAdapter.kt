package com.victor.victorosaikhuwuomwan_comp304_lab4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LandmarkAdapter(private val items: List<Landmark>, private val context: Context) :
    RecyclerView.Adapter<LandmarkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_landmark, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val landmark = items[position]
        holder.textViewName.text = landmark.name
        holder.textViewAddress.text = landmark.address

        holder.itemView.setOnClickListener {
            val intent = Intent(context, LandmarkDetailActivity::class.java).apply {
                putExtra("LANDMARK_NAME", landmark.name)
                putExtra("LANDMARK_ADDRESS", landmark.address)
                putExtra("LANDMARK_LATITUDE", landmark.latLng.latitude)
                putExtra("LANDMARK_LONGITUDE", landmark.latLng.longitude)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewLandmarkName)
        val textViewAddress: TextView = itemView.findViewById(R.id.textViewLandmarkAddress)
    }
}
