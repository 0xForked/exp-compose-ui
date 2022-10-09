package id.bakode.compose.data.model

data class User(
    val uuid: String,
    val name: String,
    val email: String,
    val FCMToken: String,
    val isOnline: Boolean
)