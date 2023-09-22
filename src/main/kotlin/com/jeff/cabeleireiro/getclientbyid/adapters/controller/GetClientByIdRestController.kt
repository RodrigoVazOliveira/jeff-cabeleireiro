package com.jeff.cabeleireiro.getclientbyid.adapters.controller

import com.jeff.cabeleireiro.getclientbyid.entities.GetClientById
import com.jeff.cabeleireiro.getclientbyid.entities.GetClientByIdPortIn
import com.jeff.cabeleireiro.registerclient.adapters.controller.responses.ClientResponse
import com.jeff.cabeleireiro.shared.commons.Loggable
import com.jeff.cabeleireiro.shared.mapper.ClientToClientResponseConvert
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import net.logstash.logback.argument.StructuredArguments
import org.jetbrains.annotations.NotNull

@Controller("/clients")
@Validated
class GetClientByIdRestController(
        private val getClientById: GetClientById,
        private val clientToClientResponseConvert: ClientToClientResponseConvert
) : GetClientByIdPortIn, Loggable {

    @Get("/{id}")
    override fun execute(@NotNull("parametro nulo") @PathVariable("id") id: Long): HttpResponse<ClientResponse> {
        LOGGER.info("inicio para obter o cliente por id. {}", StructuredArguments.kv("id", id))
        kotlin.runCatching {
            val client = getClientById.execute(id)
            val clientResponse = clientToClientResponseConvert.execute(client)

            return HttpResponse.ok(clientResponse)
        }.onFailure {
            LOGGER.error("Ocorreu um problema - {}", StructuredArguments.kv("message", it.message))
        }.getOrThrow()
    }
}