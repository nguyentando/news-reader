package com.umbrella.data.util

import com.umbrella.data.model.RestResponse
import timber.log.Timber

fun <T, R : MapDto<T>> CallFake<RestResponse<R>>.toResult(errorUtil: ErrorUtil): Result<T> {
    return try {
        val response = execute()
        if (response.isSuccessful) {
            val body = response.body()
            if (body == null) {
                Result.Error(errorUtil.categorizeException(ApiException("body null")))
            } else {
                val errorCode = body.errorCode
                Timber.e("get response error code $errorCode")
                when (errorCode) {
                    0 -> {
                        body.data?.let {
                            Result.Success(it.map())
                        } ?: Result.Error(ApiException("data is null"))
                    }
                    else -> {
                        Result.Error(errorUtil.categorizeExceptionByErrorCode(errorCode ?: -1))
                    }
                }
            }
        } else {
            Result.Error(errorUtil.categorizeException(ApiException(response.code().toString())))
        }
    } catch (e: Exception) {
        Timber.e("exception $e")
        Result.Error(errorUtil.categorizeException(e))
    }
}