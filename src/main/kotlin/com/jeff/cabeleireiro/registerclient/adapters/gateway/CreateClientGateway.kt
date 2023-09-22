package com.jeff.cabeleireiro.registerclient.adapters.gateway

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.registerclient.adapters.mapper.ClientToClientEntityConverter
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import com.jeff.cabeleireiro.shared.ClientEntityRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import com.jeff.cabeleireiro.shared.mapper.ClientEntityToClientConvert
import jakarta.inject.Singleton

@Singleton
class CreateClientGateway(
        private val clientEntityRepository: ClientEntityRepository,
        private val clientToClientEntityConverter: ClientToClientEntityConverter,
        private val clientEntityToClientConvert: ClientEntityToClientConvert
) : CreateClientRepository, Loggable {

    override fun save(client: Client): Client {
        LOGGER.info("creating new client {}", client)


        runCatching {
            val clientEntity = clientToClientEntityConverter.execute(client)
            clientEntityRepository.save(clientEntity)
            val clientCreated = clientEntityToClientConvert.execute(clientEntity)
            LOGGER.info("client created with success clientCreated: {}", clientCreated)

            return clientCreated
        }.onFailure { exception ->
            LOGGER.error(
                    "error attempt created client - message: {}, stack: {}",
                    exception.message,
                    exception.stackTraceToString()
            )
        }.getOrThrow()
    }
}