package com.estudos.challenge_zap2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_realestate.view.*

class RealEstateAdapter(
    private val realEstateList: MutableList<RealEstate>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RealEstateAdapter.RealStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealStateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_realestate, parent, false)
        return RealStateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RealStateViewHolder, position: Int) {
        val realEstate = realEstateList[position]

        Picasso.get().load(realEstateList.get(position).images[0]).into(holder.image_main)
        holder.bathroom.text = holder.bathroom.resources.getQuantityString(
            R.plurals.bathroom,
            realEstate.bathrooms,
            realEstate.bathrooms
        )
        holder.bedroom.text = holder.bedroom.resources.getQuantityString(
            R.plurals.bedroom,
            realEstate.bedrooms,
            realEstate.bedrooms
        )
        holder.parkingSpaces.text = holder.parkingSpaces.resources.getQuantityString(
            R.plurals.parking_spaces,
            realEstate.parkingSpaces,
            realEstate.parkingSpaces
        )
        holder.usableAreas.text =
            holder.usableAreas.resources.getString(R.string.usable_area, realEstate.usableAreas)
        holder.price.text =
            holder.price.resources.getString(R.string.price, realEstate.pricingInfos.price)
        holder.businessType.text =
            if (realEstate.pricingInfos.businessType == "SALE")
                holder.businessType.resources.getString(R.string.business_type_sale)
            else
                holder.businessType.resources.getString(R.string.business_type_rental)
    }

    override fun getItemCount() = realEstateList.size

    fun updateRealState(realEstate: List<RealEstate>) {
        this.realEstateList.clear()
        this.realEstateList.addAll(realEstate)
        notifyDataSetChanged()
    }

    inner class RealStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val image_main: ImageView = itemView.image_main
        val bathroom: TextView = itemView.text_bathrooms
        val bedroom: TextView = itemView.text_bedrooms
        val usableAreas: TextView = itemView.text_usablearea
        val parkingSpaces: TextView = itemView.text_parking_spaces
        val businessType: TextView = itemView.text_apartment_or_house
        val price: TextView = itemView.price

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

