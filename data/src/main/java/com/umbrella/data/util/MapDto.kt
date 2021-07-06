package com.umbrella.data.util

interface MapDto<out R> {
    fun map(): R
}
