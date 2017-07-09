package com.tenondelabs.hack2017.data.remote;

import com.tenondelabs.hack2017.data.model.Actividad;
import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Tenonde Labs
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2017 Tenonde Labs. All rights reserved
 */
public interface TenondeService {

    //Resource avances
    @GET("avances")
    Call<List<Avance>> getAvances();

    //Resource departamentos
    @GET("gobernaciones")
    Call<List<Gobernacion>> getGobernaciones();

    //Resource entidades
    @GET("entidades")
    Call<List<Entidad>> getEntidades();

    //Resource actividades
    @GET("actividades")
    Call<List<Actividad>> getActividades();

}
