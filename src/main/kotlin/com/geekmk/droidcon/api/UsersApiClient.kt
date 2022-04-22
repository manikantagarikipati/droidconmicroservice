package com.geekmk.droidcon.api

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client

@Client("users")
@Headers(
    Header(name = USER_AGENT, value = "droidcon-service"),
    Header(name = ACCEPT, value = "application/json")
)
interface UsersApiClient {
    @Get("/v0.1/users?user_id={userId}")
    fun findUserName(userId: Long): String?
}
