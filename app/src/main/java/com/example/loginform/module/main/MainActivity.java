package com.example.loginform.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.loginform.R;
import com.example.loginform.module.biodata.Biodata;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private TextView tvTimeMsg;
    private TextInputEditText editName, editPassword;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBackground();
    }

    private void initView(){
        constraintLayout = findViewById(R.id.container);
        tvTimeMsg = findViewById(R.id.tv_time_msg);



        editName = findViewById(R.id.uname);
        editPassword = findViewById(R.id.password);
        login = findViewById(R.id.btn_signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Objects.requireNonNull(editName.getText()).toString(), Objects.requireNonNull(editPassword.getText()).toString());
            }
        });
    }

    private void initBackground(){
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 16) {
            //morning
            constraintLayout.setBackground(getDrawable(R.drawable.good_morning_img));
            tvTimeMsg.setText(R.string.good_morning);
        } else {
            //night
            constraintLayout.setBackground(getDrawable(R.drawable.good_night_img));
            tvTimeMsg.setText(R.string.gooo_night);
        }
    }
    private void validate(String nama, String pw) {
        if ((nama.equals("user")) && (pw.equals("123"))) {
            Intent pindah = new Intent(MainActivity.this, Biodata.class);
            startActivity(pindah);
        } else {
            counter--;
            Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
            if (counter == 0) {
                login.setEnabled(false);
            }
        }
    }
}
