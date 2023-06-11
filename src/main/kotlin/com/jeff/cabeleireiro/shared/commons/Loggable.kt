package com.jeff.cabeleireiro.shared.commons

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Loggable {
    val LOGGER: Logger
        get() = LoggerFactory.getLogger(this::class.java)
}