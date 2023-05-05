package com.jeff.cabeleireiro.registerclient.adapters.gateway

import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityRepository
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientToClientEntityConverter
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class CreateClientGateway(
    private val clientEntityRepository: ClientEntityRepository,
    private val clientToClientEntityConverter: ClientToClientEntityConverter,
    private val clientEntityToClientConvert: ClientEntityToClientConvert
) : CreateClientRepository {
    private val logger = LoggerFactory.getLogger(CreateClientGateway::class.java)
    private val ruleName = "[CreateClient] [Gateway]"

    override fun save(client: Client): Client {
        logger.info("$ruleName [save] creating new client {}", client.toString())
        runCatching {
            val clientEntity = clientToClientEntityConverter.execute(client)
            clientEntityRepository.save(clientEntity)
            val clientCreated = clientEntityToClientConvert.execute(clientEntity)

            logger.info("$ruleName [save] client created with success {}", clientCreated)

            return clientCreated
        }.onFailure { exception ->
            logger.error(
                "$ruleName [save] error attempt created client message={}, stack={}",
                exception.message,
                exception.stackTraceToString()
            )
        }.getOrThrow()
    }


}