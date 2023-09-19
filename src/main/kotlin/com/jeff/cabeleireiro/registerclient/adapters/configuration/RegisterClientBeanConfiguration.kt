package com.jeff.cabeleireiro.registerclient.adapters.configuration

import com.jeff.cabeleireiro.registerclient.entities.CreateClient
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import com.jeff.cabeleireiro.registerclient.usecases.CreateClientUseCase
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
internal class RegisterClientBeanConfiguration {

    @Singleton
    fun getCreateClientUseCase(createClientRepository: CreateClientRepository) : CreateClient {
        return CreateClientUseCase(createClientRepository)
    }

}