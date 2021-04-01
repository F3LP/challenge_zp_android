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
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class RealEstateAdapter : RecyclerView.Adapter<RealEstateAdapter.RealStateViewHolder>() {

    var realEstate = mutableListOf<RealEstate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealStateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_realestate, parent, false)
        return RealStateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RealStateViewHolder, position: Int) {
        val realEstate = realEstate[position]

        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                Picasso.get().load(realEstate.images[position]).into(imageView)
            }
        }
        holder.carousel.pageCount = realEstate.images.size
        holder.carousel.setImageListener(imageListener)
        holder.bathroom.text =
            "${realEstate.bathrooms} ${if (realEstate.bathrooms < 2) "banheiro" else "banheiros"}"
        holder.bedroom.text =
            "${realEstate.bedrooms} ${if (realEstate.bedrooms < 2) "quarto" else "quartos"}"
        holder.usableAreas.text = "${realEstate.usableAreas} m2"
        holder.parkingSpaces.text =
            "${realEstate.parkingSpaces} ${if (realEstate.parkingSpaces < 2) "vaga" else "vagas"}"
        holder.businessType.text =
            "Apartmento para ${if (realEstate.pricingInfos.businessType == "SALE") "Venda" else "Aluguel"}"
        holder.price.text = "R$ ${realEstate.pricingInfos.price}"
    }

    override fun getItemCount() = realEstate.size

    fun updateRealState(realEstate: List<RealEstate>) {
        this.realEstate.clear()
        this.realEstate.addAll(realEstate)
        notifyDataSetChanged()
    }

    class RealStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carousel: CarouselView
        val bathroom: TextView
        val bedroom: TextView
        val usableAreas: TextView
        val parkingSpaces: TextView
        val businessType: TextView
        val price: TextView

        init {
            carousel = itemView.findViewById(R.id.carousel_view)
            bathroom = itemView.findViewById(R.id.text_bathrooms)
            bedroom = itemView.findViewById(R.id.text_bedrooms)
            usableAreas = itemView.findViewById(R.id.text_area)
            parkingSpaces = itemView.findViewById(R.id.text_parking_spaces)
            businessType = itemView.findViewById(R.id.text_apartment_or_house)
            price = itemView.findViewById(R.id.price)
        }
    }

}