package com.jeff.cabeleireiro.shared.mapper

import com.jeff.cabeleireiro.database.ClientEntity
import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.shared.commons.Loggable
import jakarta.inject.Singleton

@Singleton
class ClientEntityToClientConvert : Loggable {

    fun execute(clientEntity: ClientEntity): Client {
        LOGGER.info("convert client entity to client")
        return Client(
                id = clientEntity.id,
                nameComplete = clientEntity.nameComplete,
                email = clientEntity.email,
                numberTelephone = clientEntity.numberTelephone,
                gender = clientEntity.gender
        )
    }
}