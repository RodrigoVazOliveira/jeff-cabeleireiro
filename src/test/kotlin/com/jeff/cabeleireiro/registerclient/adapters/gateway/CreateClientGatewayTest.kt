package com.jeff.cabeleireiro.registerclient.adapters.gateway

import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityRepository
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientEntityToClientConvert
import com.jeff.cabeleireiro.registerclient.adapters.database.ClientToClientEntityConverter
import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.infrastructure.ClientEntity
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.validation.ValidationException

class CreateClientGatewayTest {
    private val clientEntityRepository: ClientEntityRepository = mockk()
    private val clientToClientEntityConverter: ClientToClientEntityConverter = mockk()
    private val clientEntityToClientConvert: ClientEntityToClientConvert = mockk()
    private val createClientGateway = CreateClientGateway(
        clientEntityRepository, clientToClientEntityConverter, clientEntityToClientConvert
    )

    @Test
    fun mustSaveNewClientWithSucess() {
        val client = Client(
            nameComplete = "Rodrigo Vaz",
            email = "rodrigo@gmail.com",
            numberTelephone = "3456564765",
            gender = "Masculino",
            id = null
        )

        val clientEntity = ClientEntity(
            id = client.id,
            nameComplete = client.nameComplete,
            email = client.email,
            numberTelephone = client.numberTelephone,
            gender = client.gender
        )
        val clientSaved = client.copy(id = 1)
        every { clientToClientEntityConverter.execute(client) } returns clientEntity
        every { clientEntityRepository.save(clientEntity) } returns clientEntity
        every { clientEntityToClientConvert.execute(clientEntity) } returns clientSaved

        val resultClientSaved = createClientGateway.save(client)

        verify { clientToClientEntityConverter.execute(client) }
        verify { clientEntityRepository.save(clientEntity) }
        verify { clientEntityToClientConvert.execute(clientEntity) }

        Assertions.assertNotNull(resultClientSaved)
        Assertions.assertEquals(clientSaved, resultClientSaved)
    }

    @Test
    fun mustSaveNewClientWithErrorValidation() {
        val client = Client(
            nameComplete = "Rodrigo Vaz",
            email = "rodrigo@gmail.com",
            numberTelephone = "3456564765",
            gender = "Masculino",
            id = null
        )

        val clientEntity = ClientEntity(
            id = client.id,
            nameComplete = client.nameComplete,
            email = client.email,
            numberTelephone = client.numberTelephone,
            gender = client.gender
        )
        val clientSaved = client.copy(id = 1)
        every { clientToClientEntityConverter.execute(client) } returns clientEntity
        every { clientEntityRepository.save(clientEntity) } throws ValidationException("Error in validation")


        val violationException =
            Assertions.assertThrows(ValidationException::class.java) { createClientGateway.save(client) }

        verify { clientToClientEntityConverter.execute(client) }
        verify { clientEntityRepository.save(clientEntity) }
        Assertions.assertEquals("Error in validation", violationException.message)
    }
}