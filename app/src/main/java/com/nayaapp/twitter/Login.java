package com.nayaapp.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nayaapp.twitter.api.Loginap;
import com.nayaapp.twitter.models.Users;
import com.nayaapp.twitter.strictmode.StrictmodeClass;


public class Login extends AppCompatActivity {
    EditText Uemail, Upassowrd;
    ImageButton ClickImg;
    TextView Txtn;
    Button btn_login;
    public static String Token = "";
    int b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Uemail = findViewById(R.id.UsersEmail);
        Upassowrd = findViewById(R.id.UsersPassword);
        ClickImg = findViewById(R.id.btn_img);
        Txtn = findViewById(R.id.TxtN);
        btn_login = findViewById(R.id.btn_login);
        Txtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ClickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b == 0) {
                    Upassowrd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    b++;

                    Upassowrd.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    b = 0;

                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(Uemail.getText().toString())) {
                    if (!TextUtils.isEmpty(Upassowrd.getText().toString())) {
                        Users users = new Users( Uemail.getText().toString(),
                                Upassowrd.getText().toString() );
                        Loginu( users );
                    } else {
                        Upassowrd.setError( "empty" );
                    }
                } else {
                    Uemail.setError( "empty" );
                }


                    }


        });

    }

    private void Loginu (Users users) {

        Loginap loginBLL = new Loginap();
        StrictmodeClass.StrictMode();
        if (loginBLL.checkUser(users.getEmail(), users.getPassword())) {
            Intent intent = new Intent(Login.this, Dashboard      .class);
            Token = Loginap.Token;
            startActivity(intent);
            //Toast.makeText( this, "welcome "+loginBLL.Token,Toast.LENGTH_SHORT ).show();

        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            // etUsername.requestFocus();


        }
    }
}
