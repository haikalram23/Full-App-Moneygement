package com.example.moneygement;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Money")
public class Money {
    @ColumnInfo(name = "id_money")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="jmlPemasukan")
    String pemasukan;

    @ColumnInfo(name = "pengeluaran")
    String pengeluaran;

    @ColumnInfo(name = "tanggal")
    String tanggal;

    @ColumnInfo(name = "keterangan")
    String keterangan;

    @ColumnInfo(name = "total")
    String total;

    public Money(String pemasukan, String pengeluaran, String tanggal, String keterangan, String total){
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.total = total;
        this.id = 0;
    }

    public void setPemasukan(String pemasukan) {
        this.pemasukan = pemasukan;
    }
    public String getPemasukan() {
        return pemasukan;
    }

    public void setPengeluaran(String pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
    public String getPengeluaran() {
        return pengeluaran;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getTanggal() {
        return tanggal;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public String getKeterangan() {
        return keterangan;
    }
}
