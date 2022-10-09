package id.bakode.compose.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "chat_id") val chatId: String?,
    @ColumnInfo(name = "user_id") val userId: String?,
    // TEXT, IMAGE, FILE, VOICE_CALL, VIDEO_CALL
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "body") val body: String?,
    // PENDING, SENT, SEEN, PULLED, DELETED
    @ColumnInfo(name = "sent_at") val sentAt: Int?,
    @ColumnInfo(name = "seen_at") val seenAt: Int?,
    @ColumnInfo(name = "pulled_at") val pulledAt: Int?,
    @ColumnInfo(name = "deleted_at") val deletedAt: Int?,
)


// [CHAT] 1 ------ * [Message]
// FILTER BY USER_ID -> (RECIPIENT or SENDER)
// ...