package aps.backflip.curlylab.data.remote.model.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    val refreshToken: String
)