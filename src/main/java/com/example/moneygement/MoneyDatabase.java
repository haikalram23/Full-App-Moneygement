package com.example.moneygement;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Money.class}, version = 1)
public abstract class MoneyDatabase extends RoomDatabase {
    public abstract MoneyDAO getMoneyDAO();
}
