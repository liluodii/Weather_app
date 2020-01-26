package com.example.weather1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit;
    private static final String Base_url = "https://www.metaweather.com/api/location/";

    public static Retrofit getRetrofitInstance(){


        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                        .baseUrl(Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;

    }
}
