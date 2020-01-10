package com.nayaapp.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    EditText SUemail, SUusername;
    ImageView sn_Us, sn_Em, back;
    Button btn_next;
    int countUsername = 0;
    int initialbtn = 0;
    String method = "email";
    String Email = "";
    String Username = "";
    boolean chekU=false;
    boolean chekE=false;
    TextView tvChange, sn_em_error, sn_us_error;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


    }
}
