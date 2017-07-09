package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rorogarcete on 09/07/17.
 */

public class DataSetEntidad {

    @SerializedName("rows")
    private List<Entidad> entidades;

    public DataSetEntidad() {}

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

}
