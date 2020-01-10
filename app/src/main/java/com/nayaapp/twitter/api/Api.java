package com.nayaapp.twitter.api;

import com.nayaapp.twitter.models.Check;
import com.nayaapp.twitter.models.ImageModel;
import com.nayaapp.twitter.models.SignUpRespo;
import com.nayaapp.twitter.models.TweetMs;
import com.nayaapp.twitter.models.Userinfo;
import com.nayaapp.twitter.models.Users;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpRespo> checkUser(@Field("email") String username, @Field("password") String password);

    @POST("users/signup")
    Call<SignUpRespo> register(@Body Users cud);

    @Multipart
    @POST("upload")
    Call<ImageModel> uploadImage(@Part MultipartBody.Part imageFile);

    @POST("users/check")
    Call<Check> check(@Body Users email);

    @POST("users/showalltweet")
    Call<List<TweetMs>> GetTweet(@Header("Authorization") String token);

    @POST("users/me")
    Call<Userinfo> getUser(@Header("Authorization") String token);
}
