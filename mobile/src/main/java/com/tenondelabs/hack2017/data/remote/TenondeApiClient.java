package com.tenondelabs.hack2017.data.remote;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tenondelabs.hack2017.TenondeLabsApplication;

import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class TenondeApiClient {

    private static final String TABLERO_AVANCE_URL = "http://192.168.0.101:3000/";
    private static final String DEPARTAMENTO_URL = "http://geo.stp.gov.py:80/user/dgeec/api/v2/sql";
    private static final String DISTRITO_URL = "http://geo.stp.gov.py:80/user/dgeec/api/v2/sql";

    public TenondeService getService() {
        return getInstanceRetrofit(TABLERO_AVANCE_URL).create(TenondeService.class);
    }

    public TenondeDepartamentoService getServiceDepartamento() {
        return getInstanceRetrofit(DEPARTAMENTO_URL).create(TenondeDepartamentoService.class);
    }

    public TenondeDistritoService getServiceDistrito() {
        return getInstanceRetrofit(DISTRITO_URL)
                .create(TenondeDistritoService.class);
    }

    private Retrofit getInstanceRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .client(TenondeLabsApplication.getInstance().getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(getInstanceGson()))
            //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

        return retrofit;
    }

    private Gson getInstanceGson() {
        GsonBuilder gsonBuilder = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            });

        return gsonBuilder.create();
    }

}
