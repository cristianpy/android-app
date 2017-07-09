package com.tenondelabs.hack2017.data.interactors;

import com.tenondelabs.hack2017.data.model.Distrito;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public interface DistritoInteractor {
    void getDistritoList();
    void loadDistritosFromStorage();
    void saveDistritos(List<Distrito> distritoList);
}
