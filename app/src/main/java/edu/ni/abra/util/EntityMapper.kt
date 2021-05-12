package edu.ni.abra.util

interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity):DomainModel
    fun mapToEntity(domainModel: DomainModel):Entity
}