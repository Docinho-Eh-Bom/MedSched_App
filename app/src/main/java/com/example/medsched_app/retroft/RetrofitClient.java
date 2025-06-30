package com.example.medsched_app.retroft;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "https://medsched-api-1.onrender.com/";
    private static RetrofitClient instance = null;
    private MedSchedApi api;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        api = retrofit.create(MedSchedApi.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance ==  null){
            instance = new RetrofitClient();
        }
        return  instance;
    }

    public MedSchedApi getApi(){
        return api;
    }
}
