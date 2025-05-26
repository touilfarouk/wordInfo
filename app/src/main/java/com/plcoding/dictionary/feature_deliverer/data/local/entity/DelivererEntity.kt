package com.plcoding.dictionary.feature_deliverer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.plcoding.dictionary.feature_deliverer.data.local.DelivererConverters
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.model.Product


@Entity
@TypeConverters(DelivererConverters::class) // Needed to store complex types like List<Product>
data class DelivererEntity(
    @PrimaryKey(autoGenerate = true)
    val delivererId: Int = 0,
    val name: String,
    val query: String,
    val product: List<Product>
) {
    fun toDeliverer(): Deliverer {
        return Deliverer(
            products = product,
            deliverer_id = delivererId.toString(),
            name = name
        )
    }
}
