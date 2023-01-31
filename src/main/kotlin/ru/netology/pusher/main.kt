package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream
fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEWPOST")
        .putData(
          "content", """{
          "userId": 3,
          "postId": 5,
          "postAuthor": "Netology",
          "content": "Продумайте, в каком формате и какими бы данными вы реализовали уведомление о новом посте.
                    Для этого вам необходимо модифицировать:
                    Push-Sender 111
                    Ваше приложение
                    Кроме того, ознакомьтесь с разделом документации, описывающей возможность "раскрытия" текста уведомления.
        }""".trimIndent()
        )
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
