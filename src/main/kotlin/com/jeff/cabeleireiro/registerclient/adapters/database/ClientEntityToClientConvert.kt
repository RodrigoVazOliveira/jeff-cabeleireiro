package com.jeff.cabeleireiro.registerclient.adapters.database

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.infrastructure.ClientEntity
import jakarta.inject.Singleton

@Singleton
class ClientEntityToClientConvert {

    fun execute(clientEntity: ClientEntity) : Client {
        return Client(
            id = clientEntity.id,
            nameComplete = clientEntity.nameComplete,
            email = clientEntity.email,
            numberTelephone = clientEntity.numberTelephone,
            gender = clientEntity.gender
        )
    }
}