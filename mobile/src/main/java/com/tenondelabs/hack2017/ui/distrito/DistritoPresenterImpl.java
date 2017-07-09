package com.tenondelabs.hack2017.ui.distrito;

import com.tenondelabs.hack2017.data.interactors.DistritoInteractor;
import com.tenondelabs.hack2017.data.model.Distrito;
import com.tenondelabs.hack2017.helpers.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase que implementa las acciones de las pantallas UI
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class DistritoPresenterImpl implements DistritoPresenter {

    private DistritoView distritoView;
    private DistritoInteractor distritoInteractor;
    private EventBus eventBus;

    public DistritoPresenterImpl(DistritoView distritoView, DistritoInteractor distritoInteractor, EventBus eventBus) {
        this.distritoView = distritoView;
        this.distritoInteractor = distritoInteractor;
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
        this.distritoView = null;
    }

    @Override
    public void getDistritos() {
        if (this.distritoView != null) {
            distritoView.showProgress();
        }

        this.distritoInteractor.getDistritoList();
    }

    @Override
    public void loadDistritos() {
        if (this.distritoView != null) {
            distritoView.showProgress();
        }

        this.distritoInteractor.loadDistritosFromStorage();
    }

    @Override
    @Subscribe
    public void onEventMainThread(DistritoEvent distritoEvent) {
        String errorMsg = distritoEvent.getError();
        if (this.distritoView != null) {
            this.distritoView.hideProgress();

            if (errorMsg != null) {
                distritoView.onEntityError(errorMsg);
            } else {
                List<Distrito> items = distritoEvent.getDistritos();
                if (items != null && !items.isEmpty()) {
                    distritoView.setDistritos(items);
                }
            }
        }
    }
}
