package com.example.shoddiq.multipletypeholder.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shoddiq on 03/11/17.
 */

public class Network {
    private static final String BASE_URL = "https://api.myjson.com/bins/";
    private final Service service;

    public Network() {
        OkHttpClient httpClient = new OkHttpClient();
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(Service.class);
    }

    public Service service() {
        return service;
    }
}
