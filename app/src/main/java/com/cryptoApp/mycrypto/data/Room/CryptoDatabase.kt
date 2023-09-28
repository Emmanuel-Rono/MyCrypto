package com.cryptoApp.mycrypto.data.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cryptoApp.mycrypto.data.CryptoEntity

@Database(entities = [CryptoEntity::class], version = 1)
abstract class CryptoDatabase: RoomDatabase()
{
    abstract fun cryptoDao():CryptoDao
    companion object {
        @Volatile
        private var INSTANCE: CryptoDatabase? = null

        fun getInstance(context: Context): CryptoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): CryptoDatabase {
            return Room.databaseBuilder(context.applicationContext, CryptoDatabase::class.java, "crypto_Database")
                .build()
        }
    }
}

