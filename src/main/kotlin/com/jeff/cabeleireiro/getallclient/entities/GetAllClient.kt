package com.jeff.cabeleireiro.getallclient.entities

import com.jeff.cabeleireiro.entities.Client

interface GetAllClient {
    fun execute() : List<Client>
}