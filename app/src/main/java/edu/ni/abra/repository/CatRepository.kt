package edu.ni.abra.repository

import edu.ni.abra.retrofit.CatNetworkMapper
import edu.ni.abra.retrofit.CatRetrofit
import edu.ni.abra.room.CacheMapper
import edu.ni.abra.room.CatDao
import edu.ni.abra.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class CatRepository constructor(
    private val catDao:CatDao,
    private val catRetrofit:CatRetrofit,
    private val cacheMapper:CacheMapper,
    private val networkMapper: CatNetworkMapper
) {
    suspend fun getCats():Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(2000)
        try {
            val catData = catRetrofit.getCats()
            val catMap = networkMapper.mapFromListEntities(catData)
            for(tempCat in catMap) {
                catDao.insertCat(cacheMapper.mapFromEntity(tempCat))
            }
            val cacheCat = catDao.getCats()
            emit(DataState.Success(cacheMapper.mapFromListEntity(cacheCat)))
        }
        catch (e:Exception) {
          //  emit(DataState.Error(e))
            val cacheCat = catDao.getCats()
            //EMIT: Es un notificador de que una accion se ha completado o ha dado un error.
            // El medio de transporte es DataState.
             emit(DataState.Success(cacheMapper.mapFromListEntity(cacheCat)))
        }
    }
}