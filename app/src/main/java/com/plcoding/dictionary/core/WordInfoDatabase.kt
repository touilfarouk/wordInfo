package com.plcoding.dictionary.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plcoding.dictionary.feature_deliverer.data.local.DelivererDao
import com.plcoding.dictionary.feature_deliverer.data.local.entity.DelivererEntity
import com.plcoding.dictionary.feature_dictionary.data.local.Converters
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDao
import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class, DelivererEntity::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
    abstract val delivererDao: DelivererDao

}