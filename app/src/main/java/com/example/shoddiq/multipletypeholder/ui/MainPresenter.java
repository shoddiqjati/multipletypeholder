package com.example.shoddiq.multipletypeholder.ui;

import com.example.shoddiq.multipletypeholder.model.CustomField;
import com.example.shoddiq.multipletypeholder.network.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shoddiq on 03/11/17.
 */

public class MainPresenter {
    private MainView mainView;
    private Network network;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        network = new Network();
    }

    public void loadResponse() {
        mainView.showProgress(true);
        Call<List<CustomField>> call = network.service().getAllField();
        call.enqueue(new Callback<List<CustomField>>() {
            @Override
            public void onResponse(Call<List<CustomField>> call, Response<List<CustomField>> response) {
                mainView.showData(response.body());
                mainView.showProgress(false);
            }

            @Override
            public void onFailure(Call<List<CustomField>> call, Throwable t) {
                t.printStackTrace();
                mainView.showProgress(false);
            }
        });
    }
}
