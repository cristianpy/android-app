package com.tenondelabs.hack2017.data.interactors;

import com.tenondelabs.hack2017.data.model.Entidad;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface EntidadInteractor {
    void getEntidadList();
    void loadEntidadesFromStorage();
    void saveEntidades(List<Entidad> entidadList);
}
