package com.jeff.cabeleireiro.registerclient.adapters.controller

import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientRequestToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.mappers.ClientToCreateClientResponseConvert
import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest
import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import com.jeff.cabeleireiro.registerclient.entities.CreateClientPortIn
import com.jeff.cabeleireiro.shared.commons.Loggable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.validation.Valid
import java.net.URI

@Controller("/clients")
open class CreateRestController(
    private val createClient: CreateClient,
    private val clientRequestToClientConvert: ClientRequestToClientConvert,
    private val clientToCreateClientResponseConvert: ClientToCreateClientResponseConvert
) : CreateClientPortIn, Loggable {

    @Post
    override fun createNewClient(@Body @Valid clientRequest: ClientRequest): Any {
        LOGGER.info("create new client clientRequest: {}", clientRequest)
        val client = clientRequestToClientConvert.execute(clientRequest)
        val createdClient = createClient.execute(client)
        val createClientResponse = clientToCreateClientResponseConvert.execute(createdClient)

        LOGGER.info("createClientResponse: {}", createClientResponse)
        return HttpResponse.created(createClientResponse, URI.create("/clients/" + createdClient.id))
    }
}