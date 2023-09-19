package com.jeff.cabeleireiro.getallclient.adapters.configuration

import com.jeff.cabeleireiro.getallclient.entities.GetAllClient
import com.jeff.cabeleireiro.getallclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.getallclient.usecases.GetAllClientUseCase
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
internal class GetAllBeanConfiguration {

    @Singleton
    fun getAllClientUseCase(getAllClientRepository: GetAllClientRepository) : GetAllClient {
        return GetAllClientUseCase(getAllClientRepository)
    }
}