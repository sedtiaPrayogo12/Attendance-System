package com.example.loginform;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginform.api.ApiRequestAttendance;
import com.example.loginform.api.Retroserver;
import com.example.loginform.model.ResponsModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.security.PublicKey;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    ConstraintLayout constraintLayout;
    TextView tvTimeMsg;
    private TextInputEditText Name;
    private TextInputEditText Password;
    private Button login;
    private int counter = 5;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.container);
        tvTimeMsg = findViewById(R.id.tv_time_msg);
        Calendar c = Calendar.getInstance();

        Name = findViewById(R.id.uname);
        Password = findViewById(R.id.password);
        login = findViewById(R.id.btn_signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });


        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay>= 0 && timeOfDay<16){
            //morning
            constraintLayout.setBackground(getDrawable(R.drawable.good_morning_img));
            tvTimeMsg.setText("Good Morning");
//        }else if(timeOfDay <= 12 && timeOfDay <16){
//            //afternoon
//        }else if(timeOfDay >= 16 && timeOfDay < 21){
//            //evening
        }else if(timeOfDay >= 16 && timeOfDay < 24){
            //night
            constraintLayout.setBackground(getDrawable(R.drawable.good_night_img));
            tvTimeMsg.setText("Good Night");
        }



    }

    private void validate(String nama,String pw){
        if ((nama.equals("Sedtia Prayogo Budi Tirto Arto")) && (pw.equals("1911126"))){
            Intent pindah = new Intent(MainActivity.this,Biodata.class);
            startActivity(pindah);
        }
        else {
            counter--;
            Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
            if (counter==0){
                login.setEnabled(false);
            }
        }
    }
}
