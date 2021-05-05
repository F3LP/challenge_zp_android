package com.estudos.challenge_zap2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.R
import com.estudos.challenge_zap2.databinding.ItemRealEstateDetailBinding
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.item_real_estate_detail.*

class ItemRealEstateDetailActivity : AppCompatActivity() {

    private lateinit var binding: ItemRealEstateDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemRealEstateDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val realEstate = intent.getParcelableExtra<RealEstate>("realEstate")

        if (realEstate != null) {

            val imageListener = ImageListener { position, imageView -> Picasso.get().load(realEstate.images[position]).into(imageView) }
            carousel_view.stopCarousel()
            carousel_view.pageCount = realEstate.images.size
            carousel_view.setImageListener(imageListener)

            text_apartment_or_house.text = if (realEstate.pricingInfos.businessType == "SALE") getString(R.string.sale) else getString(R.string.rent)
            text_city.text = if (realEstate.address.city != "") "Cidade: ${realEstate.address.city}" else "Cidade não informada"
            text_neighborhood.text = if (realEstate.address.neighborhood != "") "Bairro: ${realEstate.address.neighborhood}" else "Bairro não informado"
            text_usablearea.text = if (realEstate.usableAreas.toString() != "") "Área: ${realEstate.usableAreas}m²" else "Área não informada"
            text_bedrooms.text = if (realEstate.bedrooms.toString() != "") "Banheiros: ${realEstate.bedrooms}" else "-"
            text_bathrooms.text = if (realEstate.bathrooms.toString() != "") "Quartos: ${realEstate.bathrooms}" else "-"
            text_parking_spaces.text = if (realEstate.parkingSpaces.toString() != "") "Vagas: ${realEstate.parkingSpaces}" else "-"
            text_price.text = if (realEstate.pricingInfos.price != "") "Valor: ${realEstate.pricingInfos.price}" else "Valor não informado"
            text_condo_fee.text = if (realEstate.pricingInfos.monthlyCondoFee != "") "Taxa de condomínio: ${realEstate.pricingInfos.monthlyCondoFee}" else "Taxa de condomínio não informada"
            //text_apartment_or_house.text = realEstate.pricingInfos.businessType
            //text_neighborhood.text = realEstate.address.neighborhood
            //text_usablearea.text = realEstate.bedrooms.toString()
            //text_bedrooms.text = realEstate.bedrooms.toString()
            //text_bathrooms.text = realEstate.bathrooms.toString()
            //text_parking_spaces.text = realEstate.parkingSpaces.toString()
            //text_price.text = realEstate.pricingInfos.price
            //text_condo_fee.text = realEstate.pricingInfos.monthlyCondoFee
        } else {
            finish()
        }
    }
}