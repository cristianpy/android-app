package com.tenondelabs.hack2017.ui.gobernacion;

import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.ui.base.BaseView;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface GobernacionView extends BaseView {
    void setGobernaciones(List<Gobernacion> ciudades);
}
