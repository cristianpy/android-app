package com.tenondelabs.hack2017.data.remote;

import com.tenondelabs.hack2017.data.model.DataSetGobernacion;
import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface TenondeDepartamentoService {

    //Resource departamentos
    @GET("sql?q=SELECT dpto, dpto_desc FROM dgeec.paraguay_2012_departamentos")
    Call<DataSetGobernacion> getGobernaciones();

}
