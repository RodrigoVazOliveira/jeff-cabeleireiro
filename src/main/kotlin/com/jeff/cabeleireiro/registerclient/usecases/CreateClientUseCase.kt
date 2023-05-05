package com.jeff.cabeleireiro.registerclient.usecases

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import java.util.logging.Logger

class CreateClientUseCase(
    private val createClientRepository: CreateClientRepository
) : CreateClient {
    private val logger = Logger.getLogger(CreateClientUseCase::class.java.toString())
    private val ruleName = "[CreateClient] [UseCase]"

    override fun execute(client: Client): Client {
        logger.info("$ruleName [execute] creating client")
        return createClientRepository.save(client)
    }
}