package com.jeff.cabeleireiro.registerclient.entities

interface CreateClientRepository {
    fun save(client: Client) : Client
}