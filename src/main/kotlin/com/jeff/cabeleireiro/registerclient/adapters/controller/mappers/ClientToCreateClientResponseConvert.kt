package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.CreateClientResponse
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
open class ClientToCreateClientResponseConvert : Loggable {
    fun execute(client: Client) : CreateClientResponse {
        LOGGER.info("converting client to create client response")
        return CreateClientResponse(
            id = client.id!!,
            nameComplete = client.nameComplete!!,
            email = client.email!!,
            gender = client.gender!!,
            numberTelephone = client.numberTelephone!!
        )
    }
}