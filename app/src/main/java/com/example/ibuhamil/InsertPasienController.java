package com.example.ibuhamil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class InsertPasienController extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    InsertPasienController (Context ctx){
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String insert_url = "http://10.0.2.2/mobileService/insert_pasien.php";
        if(type.equals("insert")){
            try {
                String nama = params[1];
                String alamat = params[2];
                String no_telp = params[3];
                String kota = params[4];
                String tgl_lahir = params[5];
                String nik = params[6];
                String no_kk = params[7];
                String histori = params[8];
                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("nama", "UTF-8")+"="+URLEncoder.encode(nama, "UTF-8")+"&"
                        +URLEncoder.encode("alamat", "UTF-8")+"="+URLEncoder.encode(alamat, "UTF-8")+"&"
                        +URLEncoder.encode("no_telp", "UTF-8")+"="+URLEncoder.encode(no_telp, "UTF-8")+"&"
                        +URLEncoder.encode("kota", "UTF-8")+"="+URLEncoder.encode(kota, "UTF-8")+"&"
                        +URLEncoder.encode("tgl_lahir", "UTF-8")+"="+URLEncoder.encode(tgl_lahir, "UTF-8")+"&"
                        +URLEncoder.encode("nik", "UTF-8")+"="+URLEncoder.encode(nik, "UTF-8")+"&"
                        +URLEncoder.encode("no_kk", "UTF-8")+"="+URLEncoder.encode(no_kk, "UTF-8")+"&"
                        +URLEncoder.encode("histori", "UTF-8")+"="+URLEncoder.encode(histori, "UTF-8")+"&";
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }
    @Override
    protected void onPostExecute(String result){
        alertDialog.setMessage(result);
        alertDialog.show();

    }
}
