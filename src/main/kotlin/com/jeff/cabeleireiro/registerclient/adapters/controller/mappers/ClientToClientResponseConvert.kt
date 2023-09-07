package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.ClientResponse
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class ClientToClientResponseConvert : Loggable {
    fun execute(client: Client) : ClientResponse {
        return ClientResponse(
            id = client.id!!,
            email = client.email!!,
            nameComplete = client.nameComplete!!,
            numberTelephone = client.numberTelephone!!,
            gender = client.gender!!
        )
    }
}