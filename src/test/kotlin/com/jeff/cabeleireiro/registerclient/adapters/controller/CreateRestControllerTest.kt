package com.jeff.cabeleireiro.registerclient.adapters.controller

import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientRequestToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientToCreateClientResponseConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest
import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.CreateClientResponse
import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CreateRestControllerTest {
    private val createClient: CreateClient = mockk()
    private val clientRequestToClientConvert: ClientRequestToClientConvert = mockk()
    private val clientToCreateClientResponseConvert: ClientToCreateClientResponseConvert = mockk()
    private val createRestController = CreateRestController(
        createClient, clientRequestToClientConvert, clientToCreateClientResponseConvert
    )

    @Test
    fun mustCreateNewClientWithSucess() {
        val clientRequest = ClientRequest(
            nameComplete = "Rodrigo Vaz",
            email = "rodrigovaz@gmail.com",
            numberTelephone = "33432324",
            gender = "Masculino"
        )
        val client = Client(
            null, clientRequest.nameComplete, clientRequest.email, clientRequest.numberTelephone, clientRequest.gender
        )
        val clientSaved = client.copy(id = 1)
        val createClientResponse = CreateClientResponse(
            clientSaved.id!!,
            clientSaved.nameComplete!!,
            clientSaved.email!!,
            clientSaved.numberTelephone!!,
            clientSaved.gender!!
        )

        every { clientRequestToClientConvert.execute(clientRequest) } returns client
        every { createClient.execute(client) } returns clientSaved
        every { clientToCreateClientResponseConvert.execute(clientSaved) } returns createClientResponse

        val httpResponseCreated = createRestController.createNewClient(clientRequest)

        verify { clientRequestToClientConvert.execute(clientRequest) }
        verify { createClient.execute(client) }
        verify { clientToCreateClientResponseConvert.execute(clientSaved) }

        Assertions.assertNotNull(httpResponseCreated)

        if (httpResponseCreated is HttpResponse<*>) {
            Assertions.assertEquals(HttpStatus.CREATED, httpResponseCreated.status)
            Assertions.assertEquals(createClientResponse, httpResponseCreated.body())
        }
    }
}