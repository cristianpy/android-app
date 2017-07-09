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
public class ActividadInteractorImpl implements ActividadInteractor {

    private ActividadRepository actividadRepository;

    public ActividadInteractorImpl(actividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @Override
    public void getActividadList() {
        actividadRepository.getActividades();
    }

    @Override
    public void loadActividadesFromStorage() {
        actividadRepository.getActividadesFromStorage();
    }

    @Override
    public void saveActividades(List<Entidad> actividadList) {
        actividadRepository.saveActividadesStorage(actividadList);
    }
}
