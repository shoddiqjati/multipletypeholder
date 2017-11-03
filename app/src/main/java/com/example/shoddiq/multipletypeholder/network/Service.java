package com.example.shoddiq.multipletypeholder.network;

import com.example.shoddiq.multipletypeholder.model.CustomField;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shoddiq on 03/11/17.
 */

public interface Service {
    @GET("1a7ua3")
    Call<List<CustomField>> getAllField();
}
