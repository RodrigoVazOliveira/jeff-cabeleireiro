package com.jeff.cabeleireiro.getclientbyid.entities

import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.ClientResponse
import io.micronaut.http.HttpResponse

interface GetClientByIdPortIn {
    fun execute(id: Long): HttpResponse<ClientResponse>
}