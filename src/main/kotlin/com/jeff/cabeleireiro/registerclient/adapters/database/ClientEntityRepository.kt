package com.jeff.cabeleireiro.registerclient.adapters.database

import com.jeff.cabeleireiro.registerclient.infrastructure.ClientEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ClientEntityRepository : CrudRepository<ClientEntity, Long> {
}