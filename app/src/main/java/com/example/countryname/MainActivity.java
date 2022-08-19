package com.example.countryname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.countryname.model.CountryModel;
import com.example.countryname.model.Result;
import com.example.countryname.service.GetCountryDataService;
import com.example.countryname.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countryModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetCountries();

    }

    public void GetCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call = getCountryDataService.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if (result != null && result.getResult() != null) {
                    countryModelArrayList = (ArrayList<CountryModel>) result.getResult();

                    for (CountryModel countryModel : countryModelArrayList) {
                        Log.i("TAG", ""+countryModel.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

    }
}