package com.tenondelabs.hack2017.ui.distrito;


import com.tenondelabs.hack2017.data.model.Distrito;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Class target for event
 * Copyright 2016 Akibusca. All rights reserved
 */
public class DistritoEvent {

    private String error;
    private List<Distrito> distritos;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

}
