package com.tenondelabs.hack2017.data.interactors.impl;

import com.tenondelabs.hack2017.data.interactors.GobernacionInteractor;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.data.repository.GobernacionRepository;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class GobernacionInteractorImpl implements GobernacionInteractor {

    private GobernacionRepository gobernacionRepository;

    public GobernacionInteractorImpl(GobernacionRepository gobernacionRepository) {
        this.gobernacionRepository = gobernacionRepository;
    }

    @Override
    public void getGobernacionList() {
        gobernacionRepository.getGobernaciones();
    }

    @Override
    public void loadGobernacionesFromStorage() {
        gobernacionRepository.getGobernacionesFromStorage();
    }

    @Override
    public void saveGobernaciones(List<Gobernacion> gobernacionList) {
        gobernacionRepository.saveGobernacionesStorage(gobernacionList);
    }
}
