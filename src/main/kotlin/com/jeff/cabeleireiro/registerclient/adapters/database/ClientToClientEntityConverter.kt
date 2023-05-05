package com.jeff.cabeleireiro.registerclient.adapters.database

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.infrastructure.ClientEntity
import jakarta.inject.Singleton

@Singleton
class ClientToClientEntityConverter {
    fun execute(client: Client) : ClientEntity {
        return ClientEntity(
            id = client.id,
            nameComplete =  client.nameComplete,
            email = client.email,
            numberTelephone = client.numberTelephone,
            gender = client.gender
        )
    }
}