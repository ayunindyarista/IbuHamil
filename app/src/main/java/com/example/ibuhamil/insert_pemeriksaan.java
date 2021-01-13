package com.example.ibuhamil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class insert_pemeriksaan extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private TextView btDatePicker;
    EditText idEt, kehamilanEt, keluhanEt, tekanan_sistolEt, tekanan_diastolEt, berat_badanEt, tinggi_badanEt, umur_kehamilanEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pemeriksaan);

        idEt = (EditText)findViewById(R.id.namaPasien);
        kehamilanEt = (EditText)findViewById(R.id.kehamilan);
        keluhanEt = (EditText)findViewById(R.id.keluhan);
        tekanan_sistolEt = (EditText)findViewById(R.id.tekananDarahSistol);
        tekanan_diastolEt = (EditText)findViewById(R.id.tekananDarahDiastol);
        berat_badanEt = (EditText)findViewById(R.id.beratBadan);
        tinggi_badanEt = (EditText)findViewById(R.id.tinggiBadan);
        umur_kehamilanEt = (EditText)findViewById(R.id.umurKehamilan);

        // object dateFormatter
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tglPemeriksaan);
        btDatePicker = (TextView) findViewById(R.id.tglPemeriksaan);
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
    public void InsertPemeriksaan(View view){
        String id = idEt.getText().toString();
        String tgl_pemeriksaan = tvDateResult.getText().toString();
        String kehamilan = kehamilanEt.getText().toString();
        String keluhan = keluhanEt.getText().toString();
        String tekanan_sistol = tekanan_sistolEt.getText().toString();
        String tekanan_diastol = tekanan_diastolEt.getText().toString();
        String berat_badan = berat_badanEt.getText().toString();
        String tinggi_badan = tinggi_badanEt.getText().toString();
        String umur_kehamilan = umur_kehamilanEt.getText().toString();
        String type = "insert";
        InsertPemeriksaanController insertPemeriksaanController = new InsertPemeriksaanController(this);
        insertPemeriksaanController.execute(type, id, tgl_pemeriksaan, kehamilan, keluhan, tekanan_sistol, tekanan_diastol, berat_badan, tinggi_badan, umur_kehamilan);
    }
}