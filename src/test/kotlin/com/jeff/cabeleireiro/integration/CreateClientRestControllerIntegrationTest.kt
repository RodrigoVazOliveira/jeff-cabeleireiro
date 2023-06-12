package com.jeff.cabeleireiro.integration

import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientRequestToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientToCreateClientResponseConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest
import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.CreateClientResponse
import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

@MicronautTest
class CreateClientRestControllerIntegrationTest(
    @Client("/") private val httpClient: HttpClient,
    private val createClient: CreateClient,
    private val clientRequestToClientConvert: ClientRequestToClientConvert,
    private val clientToCreateClientResponseConvert: ClientToCreateClientResponseConvert
) {

    @Test
    fun mustCreateNewClientWithSucess() {
        val clientRequest = ClientRequest(
            nameComplete = "Rodrigo Vaz",
            email = "rodrigovaz@gmail.com",
            numberTelephone = "33432324",
            gender = "Masculino"
        )
        val client = com.jeff.cabeleireiro.registerclient.entities.Client(
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


        val objectMapper = com.fasterxml.jackson.databind.ObjectMapper()
        val payload = objectMapper.writeValueAsString(clientRequest)
        val httpCreateClientResponse =
            httpClient.toBlocking().retrieve(
                HttpRequest.POST("/clients", payload).contentType(MediaType.APPLICATION_JSON),
                CreateClientResponse::class.java
            )
    }

    @MockBean(CreateClient::class)
    fun createClient(): CreateClient {
        return mockk()
    }

    @MockBean(ClientRequestToClientConvert::class)
    fun clientRequestToClientConvert(): ClientRequestToClientConvert {
        return mockk()
    }

    @MockBean(ClientToCreateClientResponseConvert::class)
    fun clientToCreateClientResponseConvert(): ClientToCreateClientResponseConvert {
        return mockk()
    }
}