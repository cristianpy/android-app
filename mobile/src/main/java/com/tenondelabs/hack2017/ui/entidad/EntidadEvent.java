package com.tenondelabs.hack2017.ui.entidad;


import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Class target for event
 * Copyright 2016 Akibusca. All rights reserved
 */
public class EntidadEvent {

    private String error;
    private List<Gobernacion> gobernaciones;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Gobernacion> getGobernaciones() {
        return gobernaciones;
    }

    public void setGobernaciones(List<Gobernacion> gobernaciones) {
        this.gobernaciones = gobernaciones;
    }

}
