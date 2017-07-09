package com.tenondelabs.hack2017.ui.avances;

import com.tenondelabs.hack2017.ui.base.Presenter;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface AvancePresenter extends Presenter {
    void getAvances();
    void loadAvances();
    void onEventMainThread(AvanceEvent avanceEvent);
}
