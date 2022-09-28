package com.ayd.signinsignup.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayd.signinsignup.data.local.dao.UserDao
import com.ayd.signinsignup.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao



    companion object{   //singleton pattern için. her seferinde yeni veri tabanı bağlanıtıs açmayacağız.

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDb(context: Context): UserDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }



}