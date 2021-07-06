package com.umbrella.data.util

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data

fun <T, R> Result<T>.map(block: (T) -> R): Result<R> = when (this) {
    is Result.Success -> Result.Success(block(data))
    is Result.Error -> this
}

fun <T> Result<T>.getDataNonNull(): T = when (this) {
    is Result.Success -> data
    is Result.Error -> throw exception
}

fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> = when (this) {
    is Result.Success -> apply { action(data) }
    is Result.Error -> this
}

fun <T> Result<T>.onError(action: (Exception) -> Unit): Result<T> = when (this) {
    is Result.Success -> this
    is Result.Error -> apply { action(exception) }
}