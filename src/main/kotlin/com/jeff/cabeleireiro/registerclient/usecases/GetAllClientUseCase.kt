package com.jeff.cabeleireiro.registerclient.usecases

import com.jeff.cabeleireiro.registerclient.entities.Client
import com.jeff.cabeleireiro.registerclient.entities.GetAllClient
import com.jeff.cabeleireiro.registerclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable

class GetAllClientUseCase(
    private val getAllClientRepository: GetAllClientRepository
) : GetAllClient, Loggable {

    override fun execute(): List<Client> {
        LOGGER.info("get all clients")

        return getAllClientRepository.execute()
    }
}