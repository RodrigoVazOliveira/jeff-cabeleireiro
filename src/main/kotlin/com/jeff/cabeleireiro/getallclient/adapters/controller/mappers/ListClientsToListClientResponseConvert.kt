package com.jeff.cabeleireiro.getallclient.adapters.controller.mappers

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.ClientResponse
import com.jeff.cabeleireiro.shared.commons.Loggable
import com.jeff.cabeleireiro.shared.mapper.ClientToClientResponseConvert
import jakarta.inject.Singleton

@Singleton
class ListClientsToListClientResponseConvert(
        private val clientToClientResponseConvert: ClientToClientResponseConvert
) : Loggable {

    fun execute(clients: List<Client>): List<ClientResponse> {
        val listClientResponse: MutableList<ClientResponse> = mutableListOf()
        clients.forEach { client ->
            listClientResponse.add(clientToClientResponseConvert.execute(client))
        }

        return listClientResponse
    }
}