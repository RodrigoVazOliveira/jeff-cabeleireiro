package com.jeff.cabeleireiro.getclientbyid.usecases

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.getclientbyid.entities.GetClientById
import com.jeff.cabeleireiro.getclientbyid.entities.GetClientByIdRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import net.logstash.logback.argument.StructuredArguments

class GetClientByIdUseCase(
        private val getClientByIdRepository: GetClientByIdRepository
) : GetClientById, Loggable {
    override fun execute(id: Long): Client {
        LOGGER.info("get client by id.")
        val client = getClientByIdRepository.execute(id)
        LOGGER.info("execute - {}", StructuredArguments.kv("client", client))

        return client
    }
}