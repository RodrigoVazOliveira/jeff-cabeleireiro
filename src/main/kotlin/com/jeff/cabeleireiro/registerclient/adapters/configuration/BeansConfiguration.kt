package com.jeff.cabeleireiro.registerclient.adapters.configuration

import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import com.jeff.cabeleireiro.registerclient.entities.GetAllClient
import com.jeff.cabeleireiro.registerclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.registerclient.usecases.CreateClientUseCase
import com.jeff.cabeleireiro.registerclient.usecases.GetAllClientUseCase
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
internal class BeansConfiguration {

    @Singleton
    fun getCreateClientUseCase(createClientRepository: CreateClientRepository) : CreateClient {
        return CreateClientUseCase(createClientRepository)
    }

    @Singleton
    fun getAllClientUseCase(getAllClientRepository: GetAllClientRepository) : GetAllClient {
        return GetAllClientUseCase(getAllClientRepository)
    }
}