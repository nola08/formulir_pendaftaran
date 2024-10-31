package com.example.formulirpendaftaran;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Deklarasi komponen UI
    private EditText etNamaLengkap, etSurel, etNomorTelepon;
    private RadioGroup rgJenisKelamin;
    private CheckBox cbHobi1, cbHobi2, cbHobi3;
    private Button btnKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        etNamaLengkap = findViewById(R.id.etNamaLengkap);
        etSurel = findViewById(R.id.etSurel);
        etNomorTelepon = findViewById(R.id.etNomorTelepon);
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin);
        cbHobi1 = findViewById(R.id.cbHobi1);
        cbHobi2 = findViewById(R.id.cbHobi2);
        cbHobi3 = findViewById(R.id.cbHobi3);
        btnKirim = findViewById(R.id.btnKirim);

        // Set onClickListener untuk tombol Kirim
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data dari input pengguna
                String namaLengkap = etNamaLengkap.getText().toString();
                String surel = etSurel.getText().toString();
                String nomorTelepon = etNomorTelepon.getText().toString();

                // Ambil jenis kelamin yang dipilih
                String jenisKelamin = "";
                int selectedId = rgJenisKelamin.getCheckedRadioButtonId();
                if (selectedId == R.id.rbLakiLaki) {
                    jenisKelamin = "Laki-laki";
                } else if (selectedId == R.id.rbPerempuan) {
                    jenisKelamin = "Perempuan";
                }

                // Ambil daftar hobi yang dipilih
                StringBuilder hobi = new StringBuilder();
                if (cbHobi1.isChecked()) {
                    hobi.append("Membaca ");
                }
                if (cbHobi2.isChecked()) {
                    hobi.append("Olahraga ");
                }
                if (cbHobi3.isChecked()) {
                    hobi.append("Memasak ");
                }

                // Buat dan tampilkan dialog
                String message = "Nama Lengkap: " + namaLengkap + "\n" +
                        "Surel: " + surel + "\n" +
                        "Nomor Telepon: " + nomorTelepon + "\n" +
                        "Jenis Kelamin: " + jenisKelamin + "\n" +
                        "Hobi: " + (hobi.length() > 0 ? hobi.toString() : "Tidak ada hobi yang dipilih");

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Data Pendaftaran")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
