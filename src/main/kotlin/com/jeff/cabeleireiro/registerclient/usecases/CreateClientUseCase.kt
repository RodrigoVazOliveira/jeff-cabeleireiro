package com.jeff.cabeleireiro.registerclient.usecases

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable

class CreateClientUseCase(
    private val createClientRepository: CreateClientRepository
) : CreateClient, Loggable {

    override fun execute(client: Client): Client {
        LOGGER.info("creating client")
        return createClientRepository.save(client)
    }
}