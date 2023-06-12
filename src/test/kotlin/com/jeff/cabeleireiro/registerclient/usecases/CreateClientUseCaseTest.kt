package com.jeff.cabeleireiro.registerclient.usecases

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.CreateClientRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CreateClientUseCaseTest {
    private val createClientRepository: CreateClientRepository = mockk()
    private val createClientUseCase = CreateClientUseCase(createClientRepository)

    @Test
    fun musSaveNewClientWithSuccess() {
        val client = Client(
            id = null,
            nameComplete = "Rodrigo",
            email = "rodrigo@gmail.com",
            gender = "Masculino",
            numberTelephone = "34958979894"
        )
        val clientSaved = client.copy(id = 1)
        every { createClientRepository.save(client) } returns clientSaved
        val resultClientSavedWithSucess = createClientUseCase.execute(client)

        Assertions.assertNotNull(resultClientSavedWithSucess)
        Assertions.assertEquals(clientSaved, resultClientSavedWithSucess)
        verify { createClientRepository.save(client) }
    }
}