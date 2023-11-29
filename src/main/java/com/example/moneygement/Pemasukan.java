package com.example.moneygement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;

public class Pemasukan extends AppCompatActivity {
    private TextInputEditText jumlahUang;
    private AppCompatButton simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pemasukan);

        jumlahUang = findViewById(R.id.etJumlahUang);
        simpan = findViewById(R.id.btnSimpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ambilUang = jumlahUang.getText().toString();

                Intent intent = new Intent(Pemasukan.this, MainActivity.class);
                intent.putExtra("UANG_MASUK", ambilUang);
                startActivity(intent);
            }
        });

    }
}
