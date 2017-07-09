package com.tenondelabs.hack2017.ui.entidad;

import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.ui.base.BaseView;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface EntidadView extends BaseView {
    void setEntidades(List<Entidad> entidades);
}
