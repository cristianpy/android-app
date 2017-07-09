package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rorogarcete on 09/07/17.
 */

public class DataSetAvance {

    @SerializedName("rows")
    private List<Avance> avances;

    public DataSetAvance() {
    }

    public List<Avance> getAvances() {
        return avances;
    }

    public void setAvances(List<Avance> avances) {
        this.avances = avances;
    }

}


