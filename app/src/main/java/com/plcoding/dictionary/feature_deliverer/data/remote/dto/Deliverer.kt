package com.plcoding.dictionary.feature_deliverer.data.remote.dto

data class Deliverer(
    val products: List<Product>,
    val deliverer_id: String,
    val name: String
)