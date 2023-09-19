package com.jeff.cabeleireiro.registerclient.adapters.mapper

import com.jeff.cabeleireiro.database.ClientEntity
import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class ClientToClientEntityConverter : Loggable {
    fun execute(client: Client) : ClientEntity {
        LOGGER.info("convert client to client entity")
        return ClientEntity(
            id = client.id,
            nameComplete =  client.nameComplete,
            email = client.email,
            numberTelephone = client.numberTelephone,
            gender = client.gender
        )
    }
}