package com.jeff.cabeleireiro.registerclient.entities

import com.jeff.cabeleireiro.registerclient.adapters.controller.requests.ClientRequest

interface CreateClientPortIn {
    fun createNewClient(clientRequest: ClientRequest) : Any
}