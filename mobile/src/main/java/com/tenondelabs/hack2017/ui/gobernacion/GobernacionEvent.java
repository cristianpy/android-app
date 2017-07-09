package com.tenondelabs.hack2017.ui.gobernacion;


import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Class target for event
 * Copyright 2017 TenondeLabs. All rights reserved
 */
public class GobernacionEvent {

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
