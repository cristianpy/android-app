package com.tenondelabs.hack2017.ui.avances;


import com.tenondelabs.hack2017.data.model.Avance;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Class target for event
 * Copyright 2017 TenondeLabs. All rights reserved
 */
public class AvanceEvent {

    private String error;
    private List<Avance> avances;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Avance> getAvances() {
        return avances;
    }

    public void setAvances(List<Avance> avanceList) {
        this.avances = avanceList;
    }

}
