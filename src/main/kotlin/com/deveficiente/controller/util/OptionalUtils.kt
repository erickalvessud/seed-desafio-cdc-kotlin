package com.deveficiente.controller.util

import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)