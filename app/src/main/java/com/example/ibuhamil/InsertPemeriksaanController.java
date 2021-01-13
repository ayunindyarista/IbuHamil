package com.example.ibuhamil;

import android.app.AlertDialog;
import android.content.Context;
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

public class InsertPemeriksaanController extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    InsertPemeriksaanController (Context ctx){
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String insert_url = "http://10.0.2.2/mobileService/insert_pemeriksaan.php";
        if(type.equals("insert")){
            try {
                String id = params[1];
                String tgl_pemeriksaan = params[2];
                String kehamilan = params[3];
                String keluhan = params[4];
                String tekanan_sistol = params[5];
                String tekanan_diastol = params[6];
                String berat_badan = params[7];
                String tinggi_badan = params[8];
                String umur_kehamilan = params[9];
                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id, "UTF-8")+"&"
                        +URLEncoder.encode("tgl_pemeriksaan", "UTF-8")+"="+URLEncoder.encode(tgl_pemeriksaan, "UTF-8")+"&"
                        +URLEncoder.encode("kehamilan", "UTF-8")+"="+URLEncoder.encode(kehamilan, "UTF-8")+"&"
                        +URLEncoder.encode("keluhan", "UTF-8")+"="+URLEncoder.encode(keluhan, "UTF-8")+"&"
                        +URLEncoder.encode("tekanan_sistol", "UTF-8")+"="+URLEncoder.encode(tekanan_sistol, "UTF-8")+"&"
                        +URLEncoder.encode("tekanan_diastol", "UTF-8")+"="+URLEncoder.encode(tekanan_diastol, "UTF-8")+"&"
                        +URLEncoder.encode("berat_badan", "UTF-8")+"="+URLEncoder.encode(berat_badan, "UTF-8")+"&"
                        +URLEncoder.encode("tinggi_badan", "UTF-8")+"="+URLEncoder.encode(tinggi_badan, "UTF-8")+"&"
                        +URLEncoder.encode("umur_kehamilan", "UTF-8")+"="+URLEncoder.encode(umur_kehamilan, "UTF-8");
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
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }
}
