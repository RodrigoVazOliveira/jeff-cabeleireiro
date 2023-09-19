package com.jeff.cabeleireiro.registerclient.adapters.mapper

import com.jeff.cabeleireiro.entities.Client
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.UUID

class ClientToClientEntityConverterTest {

    @Test
    fun mustConvertClientToClientEntityWithSuccess() {
        val client = Client(
            id = 1,
            nameComplete = UUID.randomUUID().toString(),
            email = "rodrigo@gmail.com",
            gender = "Masculino",
            numberTelephone = "32432423"
        )

        val clientToClientEntityConverter = ClientToClientEntityConverter()
        val clientEntity = clientToClientEntityConverter.execute(client)

        Assertions.assertNotNull(clientEntity)
        Assertions.assertEquals(client.id, clientEntity.id)
        Assertions.assertEquals(client.nameComplete, clientEntity.nameComplete)
        Assertions.assertEquals(client.email, clientEntity.email)
        Assertions.assertEquals(client.numberTelephone, clientEntity.numberTelephone)
        Assertions.assertEquals(client.gender, clientEntity.gender)
    }
}