package com.tenondelabs.hack2017.data.interactors.impl;


import com.tenondelabs.hack2017.data.interactors.DistritoInteractor;
import com.tenondelabs.hack2017.data.model.Distrito;
import com.tenondelabs.hack2017.data.repository.DistritoRepository;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class DistritoInteractorImpl implements DistritoInteractor {

    private DistritoRepository distritoRepository;

    public DistritoInteractorImpl(DistritoRepository distritoRepository) {
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
        distritoRepository.saveDistritosStorage(distritoList);
    }
}
