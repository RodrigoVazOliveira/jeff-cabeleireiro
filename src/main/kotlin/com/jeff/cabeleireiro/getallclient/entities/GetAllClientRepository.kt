package com.jeff.cabeleireiro.getallclient.entities

import com.jeff.cabeleireiro.entities.Client

interface GetAllClientRepository {
    fun execute() : List<Client>
}