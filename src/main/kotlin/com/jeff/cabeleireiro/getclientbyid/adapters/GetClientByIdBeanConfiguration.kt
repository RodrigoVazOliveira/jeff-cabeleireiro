package com.jeff.cabeleireiro.getclientbyid.adapters

import com.jeff.cabeleireiro.getclientbyid.entities.GetClientById
import com.jeff.cabeleireiro.getclientbyid.entities.GetClientByIdRepository
import com.jeff.cabeleireiro.getclientbyid.usecases.GetClientByIdUseCase
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class GetClientByIdBeanConfiguration {

    @Singleton
    fun createGetClientByIdUseCase(getClientByIdRepository: GetClientByIdRepository): GetClientById {
        return GetClientByIdUseCase(getClientByIdRepository)
    }
}