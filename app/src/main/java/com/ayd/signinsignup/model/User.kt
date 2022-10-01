package com.ayd.signinsignup.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ayd.signinsignup.util.Constant.MAIL_COLUMN
import com.ayd.signinsignup.util.Constant.NAME_COLUMN
import com.ayd.signinsignup.util.Constant.PASSWORD_COLUMN
import com.ayd.signinsignup.util.Constant.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,

    @ColumnInfo(name = MAIL_COLUMN)
    val email: String?,

    @ColumnInfo(name = PASSWORD_COLUMN) val password: String?,

    @ColumnInfo(name = NAME_COLUMN) val username: String?
)
