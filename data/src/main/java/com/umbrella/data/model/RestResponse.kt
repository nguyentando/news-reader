package com.umbrella.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RestResponse<out T>(
    @SerialName("data")
    val data: T? = null,
    @SerialName("error_code")
    var errorCode: Int? = null,
    @SerialName("error_message")
    var errorMessage: String? = null,
    @SerialName("server_time")
    var serverTime: Long? = null
)