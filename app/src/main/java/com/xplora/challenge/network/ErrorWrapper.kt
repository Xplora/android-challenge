package com.xplora.challenge.network

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorWrapper {
    @SerializedName("errors")
    @Expose
    var errors: JsonObject? = null
}
