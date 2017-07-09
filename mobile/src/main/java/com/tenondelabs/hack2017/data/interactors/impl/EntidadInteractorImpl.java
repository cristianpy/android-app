package com.tenondelabs.hack2017.data.interactors.impl;

import com.tenondelabs.hack2017.data.interactors.GobernacionInteractor;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.data.repository.GobernacionRepository;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class EntidadInteractorImpl implements EntidadInteractor {

    private EntidadRepository entidadRepository;

    public EntidadInteractorImpl(entidadRepository entidadRepository) {
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
