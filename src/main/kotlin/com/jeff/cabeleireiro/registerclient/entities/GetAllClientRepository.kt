package com.jeff.cabeleireiro.registerclient.entities

interface GetAllClientRepository {
    fun execute() : List<Client>
}