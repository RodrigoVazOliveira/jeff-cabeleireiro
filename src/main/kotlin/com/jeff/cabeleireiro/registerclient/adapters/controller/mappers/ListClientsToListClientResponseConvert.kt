package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.ClientResponse
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class ListClientsToListClientResponseConvert(
    private val clientToClientResponseConvert: ClientToClientResponseConvert
) : Loggable {

    fun execute(clients: List<Client>) : List<ClientResponse> {
        val listClientResponse: MutableList<ClientResponse> = mutableListOf()
        clients.forEach {client ->
            listClientResponse.add(clientToClientResponseConvert.execute(client))
        }

        return listClientResponse
    }
}