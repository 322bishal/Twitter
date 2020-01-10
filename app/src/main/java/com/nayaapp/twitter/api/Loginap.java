package com.nayaapp.twitter.api;

import com.nayaapp.twitter.models.SignUpRespo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Loginap {

    boolean isSuccess = false;
    public static   String Token;

    public boolean checkUser(String username, String password) {

        ApiClass usersAPI = new ApiClass() {
        };
        // Url.getInstance().create(UsersAPI.class);
        Call<SignUpRespo> usersCall = usersAPI.calls().checkUser(username, password);

        try {
            Response<SignUpRespo> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {
                SignUpRespo signUpResponse=loginResponse.body();
                Token=signUpResponse.getToken();


                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
