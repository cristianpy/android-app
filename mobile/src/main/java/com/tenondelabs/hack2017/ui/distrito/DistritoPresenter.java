package com.tenondelabs.hack2017.ui.distrito;

import com.tenondelabs.hack2017.ui.base.Presenter;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface DistritoPresenter extends Presenter {
    void getDistritos();
    void loadDistritos();
    void onEventMainThread(DistritoEvent distritoEvent);
}
