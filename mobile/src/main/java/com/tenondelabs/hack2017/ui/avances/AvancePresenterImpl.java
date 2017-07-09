package com.tenondelabs.hack2017.ui.avances;

import com.tenondelabs.hack2017.data.interactors.AvanceInteractor;
import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.helpers.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Clase que implementa las acciones de las pantallas UI
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class AvancePresenterImpl implements AvancePresenter {

    private AvanceView avanceView;
    private AvanceInteractor avanceInteractor;
    private EventBus eventBus;

    public AvancePresenterImpl(AvanceView avanceView, AvanceInteractor avanceInteractor, EventBus eventBus) {
        this.avanceView = avanceView;
        this.avanceInteractor = avanceInteractor;
        this.eventBus = eventBus;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        this.avanceView = null;
    }

    @Override
    public void getAvances() {
        if (this.avanceView != null) {
            avanceView.showProgress();
        }

        this.avanceInteractor.getAvanceList();
    }

    @Override
    public void loadAvances() {
        if (this.avanceView != null) {
            avanceView.showProgress();
        }

        this.avanceInteractor.loadAvancesFromStorage();
    }

    @Override
    @Subscribe
    public void onEventMainThread(AvanceEvent avanceEvent) {
        String errorMsg = avanceEvent.getError();
        if (this.avanceView != null) {
            this.avanceView.hideProgress();

            if (errorMsg != null) {
                avanceView.onEntityError(errorMsg);
            } else {
                List<Avance> items = avanceEvent.getAvances();
                if (items != null && !items.isEmpty()) {
                    avanceView.setAvances(items);
                }
            }
        }
    }
}
