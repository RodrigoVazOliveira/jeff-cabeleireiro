package com.jeff.cabeleireiro.getallclient.adapters.controller

import com.jeff.cabeleireiro.getallclient.entities.GetAllClient
import com.jeff.cabeleireiro.getallclient.entities.GetAllClientPortIn
import com.jeff.cabeleireiro.getallclient.adapters.controller.mappers.ListClientsToListClientResponseConvert
import com.jeff.cabeleireiro.shared.commons.Loggable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/clients")
class GetAllRestController(
    private val getAllClient: GetAllClient,
    private val listClientsToListClientResponseConvert : ListClientsToListClientResponseConvert
) : GetAllClientPortIn, Loggable {

    @Get
    override fun execute(): Any {
        LOGGER.info("[execute] get All clients")
        val clients = getAllClient.execute()
        val clientResponseList = listClientsToListClientResponseConvert.execute(clients)

        LOGGER.info("sucess clientResponseList: {}", clientResponseList)
        return HttpResponse.ok(clientResponseList)
    }
}