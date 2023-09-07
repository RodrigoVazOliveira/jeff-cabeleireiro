package com.jeff.cabeleireiro.registerclient.adapters.controller.responses

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ClientResponse(
    val id: Long,
    val nameComplete: String,
    val email: String,
    val numberTelephone: String,
    val gender: String
)