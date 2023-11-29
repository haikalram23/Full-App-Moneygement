package com.example.moneygement;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;
import com.example.moneygement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton plus;
    private AppCompatTextView Rp;
    private AppCompatTextView Ket;
    private AppCompatTextView tgl;
    private AppCompatTextView duwek;
    private RecyclerView rcy;
    private CardListAdapter cardListAdapter;
    private AppCompatButton hapus;

    MoneyDatabase moneyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent received = getIntent();
        String terimaUang = received.getStringExtra("UANG_MASUK");
        String terimaktrgn = received.getStringExtra("DESKRIPSI");
        String terimatanggal = received.getStringExtra("TGL");
        String terimaUang2 = received.getStringExtra("UANG");

        Rp = findViewById(R.id.tvTotal);
        Rp.setText(terimaUang);

        moneyDB = Room.databaseBuilder(getApplicationContext(), MoneyDatabase.class, "MoneyDB").allowMainThreadQueries().build();
        hapus = findViewById(R.id.btnHapus);
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyDB.getMoneyDAO().deleteAll();
            }
        });

        plus = findViewById(R.id.fabAdd);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahData.class);
                intent.putExtra("UANG_MASUK",terimaUang);
                startActivity(intent);
            }
        });

        rcy = findViewById(R.id.rvListData);
        cardListAdapter = new CardListAdapter(this);
        rcy.setAdapter(cardListAdapter);
        rcy.setLayoutManager(new LinearLayoutManager(this));

        load();

    }

    public void load(){
        moneyDB = Room.databaseBuilder(getApplicationContext(), MoneyDatabase.class, "MoneyDB").allowMainThreadQueries().build();
        List<Money> moneyList = moneyDB.getMoneyDAO().getMoney();
        cardListAdapter.setCard(moneyList);
    }


}