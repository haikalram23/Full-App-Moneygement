package com.example.moneygement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TambahData extends AppCompatActivity {
    private TextInputEditText keterangan;
    private TextInputEditText tanggal;
    private TextInputEditText duit;
    private AppCompatButton save;
    MoneyDatabase moneyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        Intent received = getIntent();
        String masihterimauang = received.getStringExtra("UANG_MASUK");

        keterangan = findViewById(R.id.etKeterangan);
        tanggal = findViewById(R.id.etTanggal);
        duit = findViewById(R.id.etJmlUang);
        save = findViewById(R.id.btnSave);

        moneyDB = Room.databaseBuilder(getApplicationContext(), MoneyDatabase.class, "MoneyDB").allowMainThreadQueries().build();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = keterangan.getText().toString();
                String date = tanggal.getText().toString();
                String money = duit.getText().toString();

                int uang = Integer.parseInt(money);
                int pemasukan = Integer.parseInt(masihterimauang);
                int total = pemasukan - uang;
                String totalStr = String.valueOf(total);
                Money money1 = new Money(masihterimauang, money, date, desc, totalStr);

                moneyDB.getMoneyDAO().addMoney(money1);

                Intent intent = new Intent(TambahData.this, MainActivity.class);
                intent.putExtra("UANG_MASUK", totalStr);
                startActivity(intent);

            }
        });


    }



}
