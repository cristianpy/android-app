package com.tenondelabs.hack2017.data.remote;

import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Tenonde Labs
 * @version 1.0
 * Interfaz que representa la llamadas a los recursos del API
 * Copyright 2017 Tenonde Labs. All rights reserved
 */
public interface TenondeService {

    //Resource avances
    @GET("sql?q=SELECT avance_id avanceId,avance_just justificacion,avance_cant cantidad,avance_fecha " +
            "fechaAvance,accion_fecha_ini fechaInicio,accion_fecha_fin fechaFin,ins_id entidadId,sigla entidadSigla," +
            "la_id actividadId,la_nombre actividadNombre,periodo,depto_id departamentoId," +
            "depto_nombre departamentoNombre,dist_id distritoId,dist_nombre distritoNombre " +
            "FROM public.avance ORDER BY avance_fecha DESC LIMIT 25 OFFSET 0")
    Call<List<Avance>> getAvances();

    @GET("sql?q=SELECT avance_id avanceId,avance_just justificacion,avance_cant cantidad,avance_fecha fechaAvance," +
            "accion_fecha_ini fechaInicio,accion_fecha_fin fechaFin,ins_id entidadId,sigla entidadSigla,la_id actividadId," +
            "la_nombre actividadNombre,periodo,depto_id departamentoId,depto_nombre departamentoNombre,dist_id distritoId," +
            "dist_nombre distritoNombre FROM public.avance WHERE depto_id = '{deptoId}' ORDER BY avance_fecha DESC LIMIT 25 OFFSET 0")
    Call<List<Avance>> getAvancesByDepId(@Query("deptoId") String deptoId);

    @GET("sql?q=SELECT avance_id avanceId,avance_just justificacion,avance_cant cantidad,avance_fecha fechaAvance,accion_fecha_ini fechaInicio," +
            "accion_fecha_fin fechaFin,ins_id entidadId,sigla entidadSigla,la_id actividadId,la_nombre actividadNombre,periodo," +
            "depto_id departamentoId,depto_nombre departamentoNombre,dist_id distritoId,dist_nombre distritoNombre " +
            "FROM public.avance WHERE ins_id = '{entidadId}' ORDER BY avance_fecha DESC LIMIT 25 OFFSET 0")
    Call<List<Avance>> getAvancesByEntId(@Query("entidadId") String entidadId);

    //Resource departamentos
    @GET("sql?q=SELECT dpto, dpto_desc FROM dgeec.paraguay_2012_departamentos")
    Call<List<Gobernacion>> getGobernaciones();

    //Resource entidades
    @GET("sql?q=SELECT DISTINCT ins_id, sigla FROM public.avance limit 25")
    Call<List<Entidad>> getEntidades();

}
