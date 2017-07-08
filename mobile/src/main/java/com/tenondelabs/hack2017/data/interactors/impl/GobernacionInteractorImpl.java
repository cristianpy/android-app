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
public class GobernacionInteractorImpl implements GobernacionInteractor {

    private GobernacionRepository gobernacionRepository;

    public GobernacionInteractorImpl(GobernacionRepository gobernacionRepository) {
        this.gobernacionRepository = gobernacionRepository;
    }

    @Override
    public void getGobernacionList() {
        gobernacionRepository.getCiudades();
    }

    @Override
    public void loadGobernacionesFromStorage() {
        gobernacionRepository.getCiudadesFromStorage();
    }

    @Override
    public void saveGobernaciones(List<Gobernacion> gobernacionList) {
        gobernacionRepository.saveCiudadesStorage(gobernacionList);
    }
}
