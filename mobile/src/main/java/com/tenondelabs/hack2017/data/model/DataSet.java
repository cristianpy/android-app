package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rorogarcete on 09/07/17.
 */

public class DataSet {

    @SerializedName("rows")
    private List<Avance> avances;
    @SerializedName("rows")
    private List<Gobernacion> gobernaciones;
    @SerializedName("rows")
    private List<Entidad> entidades;

    public DataSet() {}

    public List<Avance> getAvances() {
        return avances;
    }

    public void setAvances(List<Avance> avances) {
        this.avances = avances;
    }

    public List<Gobernacion> getGobernaciones() {
        return gobernaciones;
    }

    public void setGobernaciones(List<Gobernacion> gobernaciones) {
        this.gobernaciones = gobernaciones;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

}
