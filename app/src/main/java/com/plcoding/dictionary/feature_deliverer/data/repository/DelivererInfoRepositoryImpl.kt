package com.plcoding.dictionary.feature_deliverer.data.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_deliverer.data.local.DelivererDao
import com.plcoding.dictionary.feature_deliverer.data.remote.DelivererApi
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.repository.DelivererInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

import java.io.IOException
class DelivererInfoRepositoryImpl(
    private val api: DelivererApi,
    private val dao: DelivererDao
): DelivererInfoRepository {
    override fun getDelivererInfo(name: String): Flow<Resource<List<Deliverer>>> = flow {
        emit(Resource.Loading())
        val deliverers = dao.getDelivererInfos(name).map { it.toDeliverer() }
        emit(Resource.Loading(data = deliverers))

        try {
            // Example: hardcode or fetch the category dynamically
         //   val category = dao.getCategoryForDeliverer(name) ?: "default-category"
            val category = "alimentaire"
            val remoteDeliverersInfo = api.getDeliverers(
                category = category,
                name = name,
                page = 1,
                perPage = 10
            )

            emit(Resource.Success<List<Deliverer>>(remoteDeliverersInfo))

        } catch(e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = deliverers
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = deliverers
            ))
        }
    }

    override fun getAllSavedDeliverers(): Flow<List<Deliverer>> {
        TODO("Not yet implemented")
    }
}