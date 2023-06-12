package com.jeff.cabeleireiro.registerclient.adapters.configuration

import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BeansConfigurationTest {
    private val createClientRepository: CreateClientRepository = mockk()
    private val beansConfiguration = BeansConfiguration()

    @Test
    fun mustCreateUseCaseCreateClient() {
        val createClientUseCase = beansConfiguration.getCreateClientUseCase(createClientRepository)
        Assertions.assertNotNull(createClientUseCase)
    }
}