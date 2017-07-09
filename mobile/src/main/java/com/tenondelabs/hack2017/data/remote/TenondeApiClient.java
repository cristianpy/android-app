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
 * @author Rodrigo Garcete
 * @version 1.0
 * Clase que representa la configuracion de la API
 * Copyright 2016 akibusca Inc. All rights reserved
 */
public class TenondeApiClient {

    private static final String TABLERO_AVANCE_URL = "http://192.168.0.101:3000/";
    private static final String DEPARTAMENTO_URL = "http://192.168.0.101:3000/";
    private static final String DISTRITO_URL = "http://192.168.0.101:3000/";

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
