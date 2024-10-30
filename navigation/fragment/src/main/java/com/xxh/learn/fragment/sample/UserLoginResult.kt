package com.xxh.learn.fragment.sample

/**
 * Authentication result : success (user details) or error message.
 */
data class UserLoginResult(
    val success: Boolean = false,
    val error: Int? = null
)