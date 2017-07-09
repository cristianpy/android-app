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
public class DepartamentoInteractorImpl implements DepartamentoInteractor {

    private DepartamentoRepository departamentoRepository;

    public DepartamentoInteractorImpl(departamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public void getDepartamentoList() {
        departamentoRepository.getDepartamentos();
    }

    @Override
    public void loadDepartamentosFromStorage() {
        departamentoRepository.getDepartamentosFromStorage();
    }

    @Override
    public void saveDepartamentos(List<Departamento> departamentoList) {
        departamentoRepository.saveDepartamentosStorage(departametntoList);
    }
}
