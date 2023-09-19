package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.entities.Client
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClientToCreateClientResponseConvertTest {

    @Test
    fun mustConverClientToClientRespoonse() {
        val client = Client(
            id = 1,
            nameComplete = "Rodrigo VAz",
            email = "rodrigo@gmail.com",
            numberTelephone = "43432423",
            gender = "Masculino"
        )

        val clientToCreateClientResponseConvert = ClientToCreateClientResponseConvert()
        val createClientResponse = clientToCreateClientResponseConvert.execute(client)

        Assertions.assertNotNull(createClientResponse)
        Assertions.assertEquals(client.id, createClientResponse.id)
        Assertions.assertEquals(client.nameComplete, createClientResponse.nameComplete)
        Assertions.assertEquals(client.email, createClientResponse.email)
        Assertions.assertEquals(client.numberTelephone, createClientResponse.numberTelephone)
        Assertions.assertEquals(client.gender, createClientResponse.gender)
    }
}