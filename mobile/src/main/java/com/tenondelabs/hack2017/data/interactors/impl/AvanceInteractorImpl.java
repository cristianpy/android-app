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
public class AvanceInteractorImpl implements AvanceInteractor {

    private AvanceRepository avanceRepository;

    public AvanceInteractorImpl(avanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    @Override
    public void getAvanceList() {
        avanceRepository.getAvances();
    }

    @Override
    public void loadAvancesFromStorage() {
        avanceRepository.getAvancesFromStorage();
    }

    @Override
    public void saveAvances(List<Avance> avanceList) {
        avanceRepository.saveAvancesStorage(avanceList);
    }
}
