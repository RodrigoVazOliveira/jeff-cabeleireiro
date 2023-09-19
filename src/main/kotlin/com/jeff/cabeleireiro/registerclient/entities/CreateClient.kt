package com.jeff.cabeleireiro.registerclient.entities

import com.jeff.cabeleireiro.entities.Client

interface CreateClient {
    fun execute(client: Client) : Client
}