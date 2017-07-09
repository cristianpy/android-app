package com.tenondelabs.hack2017.ui.entidad;

import com.tenondelabs.hack2017.ui.base.Presenter;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public interface EntidadPresenter extends Presenter {
    void getEntidades();
    void loadEntidades();
    void onEventMainThread(EntidadEvent entidadEvent);
}
