package com.example.moneygement;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoneyDAO {
    @Insert
    public void addMoney(Money money);

    @Update
    public void updateMoney(Money money);

    @Delete
    public void deleteMoney(Money money);

    @Query("DELETE FROM MONEY")
    public void deleteAll();

    @Query("select * from Money")
    public List<Money> getMoney();
}
