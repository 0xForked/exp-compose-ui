package id.bakode.compose.data.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val FCMToken: String,
    val isOnline: Boolean
)