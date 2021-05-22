package com.xplora.challenge.network

import com.google.gson.JsonObject
import com.xplora.challenge.helpers.DebugLog
import com.xplora.challenge.helpers.Utils
import com.xplora.challenge.helpers.Validation

object HttpCommonMethod {

    /**
     * check Error Message
     */
    fun getErrorMessage(error: JsonObject?): String {
        var value = ""
        if (error != null) {
            val obj = error.asJsonObject //since you know it's a JsonObject
            try {
                if (obj != null) {

                    //will return members of your object
                    val entries = obj.entrySet()

                    for ((key, value1) in entries) {
                        println(key)
                        value = value1.toString()
                    }
                }
            } catch (e: Exception) {
                DebugLog.print(e)
                value = ""
            }
        }
        return value
    }
}
