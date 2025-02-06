package com.jeff.cabeleireiro.getclientbyid.entities

import com.jeff.cabeleireiro.entities.Client


interface GetClientByIdRepository {
    fun execute(id: Long): Client
}