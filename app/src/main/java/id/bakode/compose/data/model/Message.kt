package id.bakode.compose.data.model

data class Message(
    val id: String,
    val senderId: String,
    val recipientId: String,
    val type: String,
    val body: String,
    val sentAt: Int,    // SEND AT -> AFTER PENDING
    val seenAt: Int,    // SEEN BY RECIPIENT AT
    val pulledAt: Int,  // PULLED (PULL FROM ALL USER)
    val deletedAt: Int  // DELETE (DELETE JUST FOR (SENDER/RECIPIENT)
)
