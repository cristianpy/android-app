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
public class DistritoInteractorImpl implements DistritoInteractor {

    private DistritoRepository distritoRepository;

    public DistritoInteractorImpl(distritoRepository distritoRepository) {
        this.distritoRepository = distritoRepository;
    }

    @Override
    public void getDistritoList() {
        distritoRepository.getDistritos();
    }

    @Override
    public void loadDistritosFromStorage() {
        distritoRepository.getDistritosFromStorage();
    }

    @Override
    public void saveDistritos(List<Distrito> distritoList) {
        distritoRepository.saveDistritoesStorage(distritoList);
    }
}
