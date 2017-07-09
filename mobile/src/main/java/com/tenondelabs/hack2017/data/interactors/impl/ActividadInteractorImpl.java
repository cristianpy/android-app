package com.tenondelabs.hack2017.data.interactors.impl;

import com.tenondelabs.hack2017.data.interactors.ActividadInteractor;
import com.tenondelabs.hack2017.data.model.Actividad;
import com.tenondelabs.hack2017.data.repository.ActividadRepository;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class ActividadInteractorImpl implements ActividadInteractor {

    private ActividadRepository actividadRepository;

    public ActividadInteractorImpl(ActividadRepository actividadRepository) {
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
    public void saveActividades(List<Actividad> actividadList) {
        actividadRepository.saveActividadesStorage(actividadList);
    }
}
