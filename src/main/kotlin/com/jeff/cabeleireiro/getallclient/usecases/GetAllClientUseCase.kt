package com.jeff.cabeleireiro.getallclient.usecases

import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.getallclient.entities.GetAllClient
import com.jeff.cabeleireiro.getallclient.entities.GetAllClientRepository
import com.jeff.cabeleireiro.shared.commons.Loggable

class GetAllClientUseCase(
    private val getAllClientRepository: GetAllClientRepository
) : GetAllClient, Loggable {

    override fun execute(): List<Client> {
        LOGGER.info("get all clients")

        return getAllClientRepository.execute()
    }
}