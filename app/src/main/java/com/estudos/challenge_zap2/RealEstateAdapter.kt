package com.estudos.challenge_zap2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.challenge_zap.model.RealEstate

class RealEstateAdapter: RecyclerView.Adapter<RealEstateAdapter.RealStateViewHolder>() {

    var realEstate = mutableListOf<RealEstate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealStateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_realestate, parent, false)
        return RealStateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RealStateViewHolder, position: Int) {
        val realEstate = realEstate[position]
        holder.bathroom.text = realEstate.bathrooms.toString()
        holder.bedroom.text = realEstate.bedrooms.toString()
        holder.usableAreas.text = realEstate.bathrooms.toString()
        holder.parkingSpaces.text = realEstate.parkingSpaces.toString()
        holder.businessType.text = realEstate.pricingInfos.businessType
        holder.price.text = realEstate.pricingInfos.price
    }

    override fun getItemCount() = realEstate.size

    fun updateRealState(realEstate: List<RealEstate>) {
        this.realEstate.clear()
        this.realEstate.addAll(this.realEstate)
        notifyDataSetChanged()
    }


    class RealStateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val bathroom: TextView
        val bedroom: TextView
        val usableAreas: TextView
        val parkingSpaces: TextView
        val businessType: TextView
        val price: TextView

        init {
            bathroom = itemView.findViewById(R.id.text_bathrooms)
            bedroom = itemView.findViewById(R.id.text_bedrooms)
            usableAreas = itemView.findViewById(R.id.text_area)
            parkingSpaces = itemView.findViewById(R.id.text_bathrooms)
            businessType = itemView.findViewById(R.id.text_bathrooms)
            price = itemView.findViewById(R.id.price)
        }
    }

}