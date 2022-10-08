package id.bakode.compose.data.model

data class Chat(
    val id: String,
    val user: User,
    val message: Message
)