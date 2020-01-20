package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginform.api.ApiRequestAttendance;
import com.example.loginform.api.Retroserver;
import com.example.loginform.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biodata extends AppCompatActivity {

    private Button btnAbsent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        btnAbsent = findViewById(R.id.absent);

        btnAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ApiRequestAttendance api = Retroserver.getClient().create(ApiRequestAttendance.class);

                Call<ResponsModel> sendattend = api.sendAttendance("1276867", "Sedtia Prayogo Budi Tirto Arto", "11","Rekayasa Perangkat Lunak");
                sendattend.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();

                        Toast.makeText(Biodata.this, response.body().toString(),Toast.LENGTH_SHORT).show();

                        if(kode.equals("1"))
                        {
                            Toast.makeText(Biodata.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(Biodata.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponsModel> call, Throwable t) {
                        Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                    }
                });
//                Toast.makeText(Biodata.this, "Anda sudah Absen",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
