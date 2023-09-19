package com.jeff.cabeleireiro.registerclient.entities

import com.jeff.cabeleireiro.entities.Client

interface CreateClientRepository {
    fun save(client: Client) : Client
}