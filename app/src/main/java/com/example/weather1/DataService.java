package com.example.weather1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("3534")
    Call<ArrayList<ConsolidatedWeather>> getWeathers();
//
 //   @GET("NympVMn2P")
 //   Call<List<Weather_>> getPokemonArray();



}
