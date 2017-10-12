package com.nextdot.realtimesearchwithrxandroid.Model.Networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sakib on 10/11/2017.
 */

public class RetrofitClient {

    public static final String BASE_URL = "http://sadikulsathi.com/" ;
    //public static final String image_show = "http://image.tmdb.org/t/p/w500/" ;

    public static Retrofit retrofit = null ;

    public static Retrofit getRetrofitClient(){

        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient client = new OkHttpClient() ;

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).
                    addConverterFactory(GsonConverterFactory.create(gson)).
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        }
        return retrofit ;
    }
}
