package edu.ni.abra.room

import edu.ni.abra.model.Cat
import edu.ni.abra.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<Cat, CatCacheEntity> {
    override fun mapFromEntity(entity: Cat): CatCacheEntity {
        return CatCacheEntity(
            id = entity.id,
            temperament = entity.temperament,
            origin = entity.origin,
            name = entity.name,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: CatCacheEntity): Cat {
        return Cat(
            id = domainModel.id,
            temperament = domainModel.temperament,
            origin = domainModel.origin,
            name = domainModel.name,
            image = domainModel.image
        )
    }

    fun mapFromListEntity(entities:List<CatCacheEntity>): List<Cat> {
        return entities.map { mapToEntity(it) }
    }

}