package com.tenondelabs.hack2017.data.repository;

import com.tenondelabs.hack2017.data.model.Gobernacion;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las llamadas a los APIs Rest
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface GobernacionRepository {
    void getGobernaciones();
    void getGobernacionesFromStorage();
    void saveGobernacionesStorage(List<Gobernacion> gobernacionList);
}
