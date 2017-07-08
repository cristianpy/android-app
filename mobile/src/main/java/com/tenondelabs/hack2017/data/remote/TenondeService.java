package com.tenondelabs.hack2017.data.remote;

import com.tenondelabs.hack2017.data.model.Evento;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.data.model.Institucion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2016 akibusca Inc. All rights reserved
 */
public interface TenondeService {

    //Resource ciudades
    @GET("eventos")
    Call<List<Evento>> getEventos();

    //Resource empresa ciudades
    @GET("gobernaciones")
    Call<List<Gobernacion>> getGobernaciones();

    //Resource empresa ciudades
    @GET("instituciones")
    Call<List<Institucion>> getInstituciones();

}
