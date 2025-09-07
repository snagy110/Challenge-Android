package com.seon.challenge_android.utils

sealed class ResourceResult<out R> private constructor() {
    data class Success<out T>(val data: T) : ResourceResult<T>()
    data class Error(val error: String) : ResourceResult<Nothing>()
    object Loading : ResourceResult<Nothing>()
}