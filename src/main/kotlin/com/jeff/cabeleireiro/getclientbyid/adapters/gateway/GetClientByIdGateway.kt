package com.jeff.cabeleireiro.getclientbyid.adapters.gateway

import com.jeff.cabeleireiro.database.ClientEntity
import com.jeff.cabeleireiro.entities.Client
import com.jeff.cabeleireiro.getclientbyid.entities.GetClientByIdRepository
import com.jeff.cabeleireiro.shared.ClientEntityRepository
import com.jeff.cabeleireiro.shared.commons.Loggable
import com.jeff.cabeleireiro.shared.mapper.ClientEntityToClientConvert
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton
import net.logstash.logback.argument.StructuredArguments
import java.util.*

@Singleton
class GetClientByIdGateway(
        private val clientEntityRepository: ClientEntityRepository,
        private val clientEntityToClientConvert: ClientEntityToClientConvert
) : GetClientByIdRepository, Loggable {
    override fun execute(id: Long): Client {
        LOGGER.info("obter cliente por id. {}", StructuredArguments.kv("id", id))
        val clientEntityOptional = clientEntityRepository.findById(id)
        clientNotFound(clientEntityOptional, id)
        val clientEntity = clientEntityOptional.get()
        val client = clientEntityToClientConvert.execute(clientEntity)
        LOGGER.info("cliente encontrado - {}", StructuredArguments.kv("client", client))

        return client
    }

    private fun clientNotFound(clientEntityOptional: Optional<ClientEntity>, id: Long) {
        if (clientEntityOptional.isEmpty) {
            LOGGER.warn("not found client with {}", StructuredArguments.kv("id", id))

            throw HttpStatusException(HttpStatus.NOT_FOUND, "não foi localizado cliente com id $id")
        }
    }
}