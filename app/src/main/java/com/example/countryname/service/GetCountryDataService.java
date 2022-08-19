package com.example.countryname.service;

import com.example.countryname.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    // Retrofit Interface "This interface acts as a bridge between the ModelClass & Retrofit Instance"

    @GET("countries")
    Call<Result> getResult();

}
