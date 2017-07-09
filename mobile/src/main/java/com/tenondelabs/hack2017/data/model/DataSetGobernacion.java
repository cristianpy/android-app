package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rorogarcete on 09/07/17.
 */

public class DataSetGobernacion {

    @SerializedName("rows")
    private List<Gobernacion> gobernaciones;

    public DataSetGobernacion() {}

    public List<Gobernacion> getGobernaciones() {
        return gobernaciones;
    }

    public void setGobernaciones(List<Gobernacion> gobernaciones) {
        this.gobernaciones = gobernaciones;
    }

}
