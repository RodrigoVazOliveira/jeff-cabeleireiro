package com.jeff.cabeleireiro.registerclient.adapters.controller.mappers

import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClientRequestToClientConvertTest {

    @Test
    fun mustConvertClientRequestToClient() {
        val clientRequest = ClientRequest(
            nameComplete = "Rodrigo",
            email = "rodrigovaz@gmail.com",
            numberTelephone = "423432432",
            gender = "Masculino"
        )

        val clientRequestToClientConvert = ClientRequestToClientConvert()
        val client = clientRequestToClientConvert.execute(clientRequest)

        Assertions.assertNotNull(client)
        Assertions.assertEquals(clientRequest.nameComplete, client.nameComplete)
        Assertions.assertEquals(clientRequest.email, client.email)
        Assertions.assertEquals(clientRequest.numberTelephone, client.numberTelephone)
        Assertions.assertEquals(clientRequest.gender, client.gender)
    }
}