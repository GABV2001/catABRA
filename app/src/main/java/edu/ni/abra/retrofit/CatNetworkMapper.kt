package edu.ni.abra.retrofit

import edu.ni.abra.model.Cat
import edu.ni.abra.util.EntityMapper
import javax.inject.Inject

class CatNetworkMapper
@Inject
constructor():EntityMapper<CatNetworkEntity, Cat> {
    override fun mapFromEntity(entity: CatNetworkEntity): Cat {
        return Cat(
            id = entity.id,
            temperament = entity.temperament,
            origin = entity.origin,
            name = entity.name,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Cat): CatNetworkEntity {
        return CatNetworkEntity(
            id = domainModel.id,
            temperament = domainModel.temperament,
            origin = domainModel.origin,
            name = domainModel.name,
            image = domainModel.image
        )
    }

    fun mapFromListEntities(entities:List<CatNetworkEntity>): List<Cat> {
        return  entities.map { mapFromEntity(it) }
    }

}