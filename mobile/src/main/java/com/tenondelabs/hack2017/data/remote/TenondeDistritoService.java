package com.tenondelabs.hack2017.data.remote;

import com.tenondelabs.hack2017.data.model.Distrito;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2016 akibusca Inc. All rights reserved
 */
public interface TenondeDistritoService {

    //Resource ciudades
    @GET("distrito")
    Call<List<Distrito>> getEventos();

}
