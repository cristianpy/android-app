package com.tenondelabs.hack2017.data.repository;

import com.tenondelabs.hack2017.data.model.Distrito;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que encapsula las llamadas a los APIs Rest
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public interface DistritoRepository {
    void getDistritos();
    void getDistritosFromStorage();
    void saveDistritosStorage(List<Distrito> distritoList);
}
