package com.xplora.challenge.helpers

object Utils {

    fun removeArrayBrace(message: String): String {
        return message.replace("[\"", "").replace("\"]", "").replace(".", "")
    }
}