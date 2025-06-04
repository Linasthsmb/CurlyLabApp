package aps.backflip.curlylab.data.remote.model.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)