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

    private static final String PRODUCTION_URL = "http://192.168.0.101:3000/";
//    public static final String IMAGE_URL        = "http://192.168.0.103:3000";

//    private static final String PRODUCTION_URL  = "http://52.200.90.11/";
//    public static final String IMAGE_URL        = "http://52.200.90.11/";

    public TenondeService getService() {
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

        Gson gson = gsonBuilder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PRODUCTION_URL)
                .client(TenondeLabsApplication.getInstance().getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(TenondeService.class);
    }

}
