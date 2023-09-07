package com.jeff.cabeleireiro.registerclient.adapters.gateway

import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntitiesToClientsConvert
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityRepository
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class GetAllClientGateway(
    private val clientEntityRepository: ClientEntityRepository,
    private val clientEntitiesToClientsConvert: ClientEntitiesToClientsConvert
) : GetAllClientRepository, Loggable {
    override fun execute(): List<Client> {
        LOGGER.info("get all clients in database");
        runCatching {
            val clientEntities = clientEntityRepository.findAll()
            LOGGER.info("get all client with success clients: {}", clientEntities)

            return clientEntitiesToClientsConvert.execute(clientEntities)
        }.onFailure { exception ->
            LOGGER.error(
                "error get all clients - message: {}, stack: {}",
                exception.message,
                exception.stackTraceToString()
            )
        }.getOrThrow()
    }
}