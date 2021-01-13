package com.example.ibuhamil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class insert_pasien extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private TextView btDatePicker;
    EditText namaEt, alamatEt, kotaEt, nikEt, no_kkEt, historiEt, no_telpEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pasien);

        namaEt = (EditText)findViewById(R.id.namaPasien);
        alamatEt = (EditText)findViewById(R.id.alamat);
        kotaEt = (EditText)findViewById(R.id.kota);
        nikEt = (EditText)findViewById(R.id.NIK);
        no_kkEt = (EditText)findViewById(R.id.noKK);
        historiEt = (EditText)findViewById(R.id.historiKesehatan);
        no_telpEt = (EditText)findViewById(R.id.noTelp);

        // object dateFormatter
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tglLahir);
        btDatePicker = (TextView) findViewById(R.id.tglLahir);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(); // method showDateDialog
            }
        });
        // ---------------------- akhir -----------------------------
    }
    //Implementasi showDateDialog
    //-------------------------------------------------------------
    private void showDateDialog(){
        // Calendar untuk mendapatkan tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();
        // Inisiasi DataPicker dialog
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Set calender untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                // update TextView dengan tanggal yang dipilih
                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));
        //Tampilkan DatePicker dialog
        datePickerDialog.show();
    }

    public void InsertPasien(View view){
        String nama = namaEt.getText().toString();
        String alamat = alamatEt.getText().toString();
        String no_telp = no_telpEt.getText().toString();
        String kota = kotaEt.getText().toString();
        String tgl_lahir = tvDateResult.getText().toString();
        String nik = nikEt.getText().toString();
        String no_kk = no_kkEt.getText().toString();
        String histori = historiEt.getText().toString();
        String type = "insert";
        InsertPasienController insertPasienController = new InsertPasienController(this);
        insertPasienController.execute(type, nama, alamat, no_telp, kota, tgl_lahir, nik, no_kk, histori);
    }
}