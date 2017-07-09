package com.tenondelabs.hack2017.ui.avances;

import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.ui.base.BaseView;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface AvanceView extends BaseView {
    void setAvances(List<Avance> avances);
}
