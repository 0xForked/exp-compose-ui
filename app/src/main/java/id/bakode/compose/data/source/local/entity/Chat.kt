package id.bakode.compose.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chat(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "recipient_id") val recipientId: String?,
)