package com.udtt.applegamsung.data.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

/**
 * Created By Yun Hyeok
 * on 3월 14, 2020
 */

@Entity
@IgnoreExtraProperties
data class TestResult(
    val deviceId: String,
    val nickname: String,
    val totalScore: Int,

    @ServerTimestamp
    val timeStamp: Date = Date(System.currentTimeMillis()),

    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
) {
    @Ignore
    var productList: List<String> = emptyList()
}