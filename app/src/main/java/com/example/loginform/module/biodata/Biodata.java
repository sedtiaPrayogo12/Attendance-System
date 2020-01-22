package com.example.loginform.module.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginform.R;
import com.example.loginform.service.APIService;
import com.example.loginform.service.RetrofitService;
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
        initViews();

    }

    private void initViews(){
        btnAbsent = findViewById(R.id.absent);
        btnAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });
    }

    private void postData(){
        APIService api = RetrofitService.getAPIService();

        Call<ResponsModel> sendAttend = api.sendAttendance("Sedtia Prayogo Budi Tirto Arto", 11, "Rekayasa Perangkat Lunak");
        sendAttend.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(retrofit2.Call<ResponsModel> call, Response<ResponsModel> response) {
                Log.d("RETRO", "response : " + response.body().toString());
                int kode = response.body().getKode();

                Toast.makeText(Biodata.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                if (kode == 1) {
                    Toast.makeText(Biodata.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Biodata.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponsModel> call, Throwable t) {
                Log.d("RETRO", "Falure : " + t.getMessage());
            }
        });
    }
}