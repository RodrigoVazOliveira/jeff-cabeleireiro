package com.jeff.cabeleireiro.getclientbyid.entities

import com.jeff.cabeleireiro.entities.Client


interface GetClientById {
    fun execute(id: Long): Client
}