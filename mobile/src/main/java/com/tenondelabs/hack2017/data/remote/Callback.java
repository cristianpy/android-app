package com.tenondelabs.hack2017.data.remote;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase wrapper que envuelve el Callback de retrofit2
 * Copyright 2017 TeondeLabs Inc. All rights reserved
 */
public abstract class Callback<T> implements retrofit2.Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            success(response.body());
        } else {
            try {
                final Exception e = new Exception(response.errorBody().string());
//                Timber.e(e, "Response error");
                Log.d("Callback", "Response error");
                failure(e);
            } catch (IOException e) {
//                Timber.e(e, "Network error after response error!");
                Log.d("Callback", "Network error after response error!");
                failure(e);
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
//        Timber.d(t, "Network failure!");
        Log.d("Callback", "Network failure");
        networkFailure(t);
    }

    public void failure(Throwable error) {
    }

    public void networkFailure(Throwable error) {
    }

    public abstract void success(T response);
}
