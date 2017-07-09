package com.tenondelabs.hack2017.data.interactors.impl;

import com.tenondelabs.hack2017.data.interactors.EntidadInteractor;
import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.data.repository.EntidadRepository;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class EntidadInteractorImpl implements EntidadInteractor {

    private EntidadRepository entidadRepository;

    public EntidadInteractorImpl(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
    }

    @Override
    public void getEntidadList() {
        entidadRepository.getEntidades();
    }

    @Override
    public void loadEntidadesFromStorage() {
        entidadRepository.getEntidadesFromStorage();
    }

    @Override
    public void saveEntidades(List<Entidad> entidadList) {
        entidadRepository.saveEntidadesStorage(entidadList);
    }
}
