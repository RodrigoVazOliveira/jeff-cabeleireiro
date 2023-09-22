package com.jeff.cabeleireiro.getallclient.usecases

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.getallclient.entities.GetAllClient
import com.jeff.cabeleireiro.getallclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import net.logstash.logback.argument.StructuredArguments

class GetAllClientUseCase(
    private val getAllClientRepository: GetAllClientRepository
) : GetAllClient, Loggable {

    override fun execute(): List<Client> {
        LOGGER.info("get all clients")
        val clients = getAllClientRepository.execute()
        LOGGER.info("execute - {}", StructuredArguments.kv("clients", clients))

        return clients
    }
}