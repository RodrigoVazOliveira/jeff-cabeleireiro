package com.jeff.cabeleireiro.registerclient.adapters.gateway

import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityRepository
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientToClientEntityConverter
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton
import net.logstash.logback.argument.StructuredArguments.kv

@Singleton
class CreateClientGateway(
    private val clientEntityRepository: ClientEntityRepository,
    private val clientToClientEntityConverter: ClientToClientEntityConverter,
    private val clientEntityToClientConvert: ClientEntityToClientConvert
) : CreateClientRepository, Loggable {

    override fun save(client: Client): Client {
        LOGGER.info("creating new client {}", kv("client", client))
        runCatching {
            val clientEntity = clientToClientEntityConverter.execute(client)
            clientEntityRepository.save(clientEntity)
            val clientCreated = clientEntityToClientConvert.execute(clientEntity)
            LOGGER.info("client created with success {}", kv("clientCreated", clientCreated))

            return clientCreated
        }.onFailure { exception ->
            LOGGER.error(
                "error attempt created client {}, {}",
                kv("message", exception.message),
                kv("stack", exception.stackTraceToString())
            )
        }.getOrThrow()
    }
}