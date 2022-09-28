package com.ayd.signinsignup.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,

    @ColumnInfo(name = "email")
    val email: String?,

    @ColumnInfo(name = "password") val password: String?,

    @ColumnInfo(name = "username") val username: String?
)
