package id.bakode.compose.data.repository

class ChatRepositoryImpl : ChatRepositoryContract {}


//
// [message] ---> [local_database (pending)] (offline)
//
// [message] ---> [local_database (pending)]
//     |------> [firestore (sent)]
//     |------> [cloud messaging [sent]]
//