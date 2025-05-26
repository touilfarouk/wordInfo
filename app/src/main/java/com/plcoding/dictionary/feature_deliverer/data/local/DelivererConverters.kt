package com.plcoding.dictionary.feature_deliverer.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.plcoding.dictionary.core.util.JsonParser


@ProvidedTypeConverter
class DelivererConverters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromDelivererJson(json: String): List<Deliverer> {
        return jsonParser.fromJson<ArrayList<Deliverer>>(
            json,
            object : TypeToken<ArrayList<Deliverer>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toDelivererJson(deliverer: List<Deliverer>): String {
        return jsonParser.toJson(
            deliverer,
            object : TypeToken<ArrayList<Deliverer>>(){}.type
        ) ?: "[]"
    }
}