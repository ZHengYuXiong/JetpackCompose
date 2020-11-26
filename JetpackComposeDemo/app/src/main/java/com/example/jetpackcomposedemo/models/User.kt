package com.example.jetpackcomposedemo.models

/**
 * 用户类
 */
data class User(
    val name: String,
    val username: String,
    val avatar: Int,
    val banner: Int,
    val bio: String,
    val following: Int,
    val followers: Int,
    val verified: Boolean
)

