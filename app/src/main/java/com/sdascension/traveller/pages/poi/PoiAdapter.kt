package com.sdascension.traveller.pages.poi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sdascension.traveller.R
import com.sdascension.traveller.pages.info.InfoActivity
import com.squareup.picasso.Picasso

// Adapter for Poi Recycler View
class PoiAdapter(
    private val poi: List<Poi>,
    private val mContext: Context,
    private val onClick: (Poi?) -> Unit,
) :
    RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {


    // Holder for Poi Recycler View
    inner class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.txtPoiTitle)
        val description: TextView = itemView.findViewById(R.id.txtPoiDescription)
        val image: ImageView = itemView.findViewById(R.id.imgPoi)
        val punctuation: TextView = itemView.findViewById(R.id.txtPoiPunctuation)
        private var currentPoi: Poi? = null

        init {
            itemView.setOnClickListener {
                onClick(currentPoi)
            }
        }

        fun bind(poi: Poi) {
            currentPoi = poi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.poi, parent, false)
        return PoiViewHolder(v)
    }

    override fun getItemCount(): Int {
        return poi.size
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = poi[position]
        // Onclick for every single recycler view item, passing information to Info Activity
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, InfoActivity::class.java)
            intent.putExtra("title", poi.title)
            intent.putExtra("description", poi.description)
            intent.putExtra("completedesc", poi.completedesc)
            intent.putExtra("punctuation", poi.punctuation)
            intent.putExtra("image", poi.image)
            intent.putExtra("latitude", poi.latitude)
            intent.putExtra("longitude", poi.longitude)
            mContext.startActivity(intent)
        }
        // Set the recyclers view information
        holder.title.text = poi.title
        holder.description.text = poi.description
        Picasso.get().load(poi.image).into(holder.image)
        holder.punctuation.text = poi.punctuation
        holder.bind(poi = poi)
    }


}

