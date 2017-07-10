package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by tenondelabs on 08/07/17.
 */

public class Avance extends RealmObject {

    @Expose(serialize = false, deserialize = false)
    private Long id;
    @SerializedName("avanceid")
    private String avanceId;
    private String justificacion;
    private String cantidad;
    @SerializedName("fechaavance")
    private String fechaAvance;
    @SerializedName("fechainicio")
    private String fechaInicio;
    @SerializedName("fechafin")
    private String fechaFin;
    @SerializedName("entidadid")
    private String entidadId;
    @SerializedName("entidadsigla")
    private String entidadSigla;
    @SerializedName("actividadid")
    private String actividadId;
    @SerializedName("actividadnombre")
    private String activadaNombre;
    private String periodo;
    @SerializedName("departamentoid")
    private String departamentoId;
    @SerializedName("departamentonombre")
    private String departamentoNombre;
    @SerializedName("distritoid")
    private String distritoId;
    @SerializedName("distritonombre")
    private String distritoNombre;

    private String imagen;

    public Avance() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEntidadSigla() {
        return entidadSigla;
    }

    public void setEntidadSigla(String entidadSigla) {
        this.entidadSigla = entidadSigla;
    }


    public String getActivadaNombre() {
        return activadaNombre;
    }

    public void setActivadaNombre(String activadaNombre) {
        this.activadaNombre = activadaNombre;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public String getDistritoNombre() {
        return distritoNombre;
    }

    public void setDistritoNombre(String distritoNombre) {
        this.distritoNombre = distritoNombre;
    }

    public String getAvanceId() {
        return avanceId;
    }

    public void setAvanceId(String avanceId) {
        this.avanceId = avanceId;
    }

    public String getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(String entidadId) {
        this.entidadId = entidadId;
    }

    public String getActividadId() {
        return actividadId;
    }

    public void setActividadId(String actividadId) {
        this.actividadId = actividadId;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(String distritoId) {
        this.distritoId = distritoId;
    }

    public String getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(String fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
