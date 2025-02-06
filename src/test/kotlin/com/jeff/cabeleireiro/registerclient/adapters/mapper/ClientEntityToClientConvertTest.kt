package com.jeff.cabeleireiro.registerclient.adapters.mapper

import com.jeff.cabeleireiro.database.ClientEntity
import com.jeff.cabeleireiro.shared.mapper.ClientEntityToClientConvert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClientEntityToClientConvertTest {

    @Test
    fun mustConvertEntityToClient() {
        val clientEntity = ClientEntity(
                id = 1,
                nameComplete = "Test",
                email = "test@gmail.com",
                numberTelephone = "432423",
                gender = "Masculino"
        )
        val clientEntityToClientConvert = ClientEntityToClientConvert()
        val client = clientEntityToClientConvert.execute(clientEntity)

        Assertions.assertNotNull(client)
        Assertions.assertEquals(clientEntity.id, client.id)
        Assertions.assertEquals(clientEntity.nameComplete, client.nameComplete)
        Assertions.assertEquals(clientEntity.email, client.email)
        Assertions.assertEquals(clientEntity.numberTelephone, client.numberTelephone)
        Assertions.assertEquals(clientEntity.gender, client.gender)
    }
}