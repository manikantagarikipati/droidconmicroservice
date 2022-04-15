package com.geekmk.droidcon.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoItemDto(
    @JsonProperty("title")
    val title: String
)
