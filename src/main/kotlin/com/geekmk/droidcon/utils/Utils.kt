package com.geekmk.droidcon.utils

import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneId

@Singleton
class Utils {
    fun getGMTUnixtime(): LocalDateTime {
        val instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
        return LocalDateTime.ofInstant(instant, ZoneId.of("GMT"))
    }
}
