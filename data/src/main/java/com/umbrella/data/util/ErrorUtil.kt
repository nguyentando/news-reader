package com.umbrella.data.util

import android.util.Log
import android.util.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.HttpException
import timber.log.Timber
import java.io.FileNotFoundException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorUtil @Inject constructor(private val networkUtils: NetworkUtils) {
    fun categorizeException(e: Exception): Exception {
        val isTimeoutException = e is SocketTimeoutException || e is ConnectTimeoutException
        Timber.e(if (isTimeoutException) e.toString() else Log.getStackTraceString(e))

        if (!networkUtils.hasNetworkConnection()) {
            return NoConnectionException()
        }
        if (e is HttpException) {
            //status code != 2xx: 404, 502
            return ConnectException()
        }
        if (e is SocketTimeoutException || e is ConnectTimeoutException) {
            return TimeoutException()
        }
        if (e is UnknownHostException || e is MalformedJsonException || e is FileNotFoundException) {
            return ConnectException()
        }
        return UnknownException
    }

    fun categorizeExceptionByErrorCode(code: Int): Exception {
        return when (code) {
            -102 -> {
                InaccurateDateTimeException()
            }
            -104, -105 -> {
                InvalidDataOrSignatureException()
            }
            -404, -405 -> {
                InvalidObjectException()
            }
            -613, -801 -> {
                SessionExpiredException()
            }
            -614 -> {
                LoggedIntoAnotherDeviceException()
            }
            -616 -> {
                UserBlockedException()
            }
            else -> {
                RestException()
            }
        }
    }
}

open class BaseException(private val mes: String) : Exception() {
    override fun toString(): String {
        return mes
    }
}

class InaccurateDateTimeException : BaseException("Your phone date time is inaccurate")
class InvalidDataOrSignatureException : BaseException("Invalid data")
class InvalidObjectException : BaseException("This content doesn\'t exist or is temporary unavailable")
class SessionExpiredException : BaseException("Session timed out")
class LoggedIntoAnotherDeviceException : BaseException("Your account has been logged into another device")
class UserBlockedException : BaseException("Your account has been disabled")
class RestException : BaseException("Something went wrong")
class ConnectException : BaseException("Can\'t connect to server")
class TimeoutException : BaseException("Connection timed out")
object UnknownException : BaseException("Something went wrong")
class NoConnectionException : BaseException("No connection")
class SignInException(msg: String) : BaseException(msg)
class ApiException(msg: String) : BaseException(msg)
class EtagConfigException(message: String) : BaseException(message)
object UserException : BaseException("Not have user")
object SessionException : BaseException("Not have session")