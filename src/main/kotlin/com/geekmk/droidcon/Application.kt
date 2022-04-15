package com.geekmk.droidcon

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "droidconservice",
        description = "APIs that handles all the functionalities related to DroidCon",
        contact = Contact(
            url = "",
            name = "DroidCon",
            email = "manikanta.garikipati@gmail.com",
        ),
    ),
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application.javaClass)
    }
}
