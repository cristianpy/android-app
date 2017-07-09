package com.tenondelabs.hack2017.data.interactors;

import com.tenondelabs.hack2017.data.model.Avance;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface AvanceInteractor {
    void getAvanceList();
    void loadAvancesFromStorage();
    void saveAvances(List<Avance> avanceList);
}
