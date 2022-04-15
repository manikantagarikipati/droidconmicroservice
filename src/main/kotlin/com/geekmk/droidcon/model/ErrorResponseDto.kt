package com.geekmk.droidcon.model

data class ErrorResponseDto(
    val errors: List<ErrorItem>? = emptyList()
)

data class ErrorItem(
    val code: String,
    val message: String
)
