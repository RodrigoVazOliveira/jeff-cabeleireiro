package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
open class ClientRequestToClientConvert : Loggable {

    fun execute(clientRequest: ClientRequest) : Client {
        LOGGER.info("convert client request to client")
        return Client(
            nameComplete = clientRequest.nameComplete,
            email = clientRequest.email,
            numberTelephone = clientRequest.numberTelephone,
            gender = clientRequest.gender,
            id = null
        )
    }
}