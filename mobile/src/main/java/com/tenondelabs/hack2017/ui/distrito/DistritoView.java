package com.tenondelabs.hack2017.ui.distrito;

import com.tenondelabs.hack2017.data.model.Distrito;
import com.tenondelabs.hack2017.ui.base.BaseView;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las acciones de la vista
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface DistritoView extends BaseView {
    void setDistritos(List<Distrito> distrios);
}
