package com.jeff.cabeleireiro.registerclient.adapters.database

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.infrastructure.ClientEntity
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class ClientEntitiesToClientsConvert(
    private val clientEntityToClientConvert: ClientEntityToClientConvert
) : Loggable {

    fun execute(clientEntities: Iterable<ClientEntity>) : List<Client> {
        LOGGER.info("convert client entities to clients")
        val clients: MutableList<Client> = mutableListOf()

        clientEntities.forEach { clientEntity ->
            clients.add(clientEntityToClientConvert.execute(clientEntity))
        }

        return clients
    }
}