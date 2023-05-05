package com.jeff.cabeleireiro.registerclient.entities

interface CreateClient {
    fun execute(client: Client) : Client
}