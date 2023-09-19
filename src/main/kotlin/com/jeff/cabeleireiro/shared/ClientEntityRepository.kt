package com.jeff.cabeleireiro.shared

import com.jeff.cabeleireiro.database.ClientEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ClientEntityRepository : CrudRepository<ClientEntity, Long> {

}