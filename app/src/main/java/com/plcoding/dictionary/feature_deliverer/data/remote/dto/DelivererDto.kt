package com.plcoding.dictionary.feature_deliverer.data.remote.dto

data class DelivererDto(
    val deliverer: List<Deliverer>,
    val page: Int,
    val per_page: Int,
    val total_pages: Int,
    val total_results: String
)