package com.jeff.cabeleireiro.registerclient.adapters.controller.requests

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
@Serdeable
data class ClientRequest(
    @field:NotBlank(message = "Name Complete is required")
    @field:Size(min = 3, max = 150, message = "Name Complete min 3 and max 150 characters")
    val nameComplete: String,

    @field:NotBlank(message = "e-mail is required")
    @field:Email(message = "e-mail not is valid")
    @field:Size(min = 10, max = 300, message = "e-mail is minimium 10 characters and e-mail is max 300 characters")
    val email: String,

    @field:NotBlank(message = "number telephone is required")
    @field:Size(min = 10, max = 30, message = "number telephone is minimium 10 characters and number telephone is max 30 characters")
    val numberTelephone: String,

    @field:NotBlank(message = "gender is required")
    @field:Size(min = 3, max = 70, message = "gender is minimium 3 characters and gender is max 70 characters")
    val gender: String
)