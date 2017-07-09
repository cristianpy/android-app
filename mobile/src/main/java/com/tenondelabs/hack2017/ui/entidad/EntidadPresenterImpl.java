package com.tenondelabs.hack2017.ui.entidad;

import com.tenondelabs.hack2017.data.interactors.EntidadInteractor;
import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.helpers.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase que implementa las acciones de las pantallas UI
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class EntidadPresenterImpl implements EntidadPresenter {

    private EntidadView entidadView;
    private EntidadInteractor entidadInteractor;
    private EventBus eventBus;

    public EntidadPresenterImpl(EntidadView entidadView, EntidadInteractor entidadInteractor, EventBus eventBus) {
        this.entidadView = entidadView;
        this.entidadInteractor = entidadInteractor;
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
        this.entidadView = null;
    }

    @Override
    public void getEntidades() {
        if (this.entidadView != null) {
            entidadView.showProgress();
        }

        this.entidadInteractor.getEntidadList();
    }

    @Override
    public void loadEntidades() {
        if (this.entidadView != null) {
            entidadView.showProgress();
        }

        this.entidadInteractor.loadEntidadesFromStorage();
    }

    @Override
    @Subscribe
    public void onEventMainThread(EntidadEvent entidadEvent) {
        String errorMsg = entidadEvent.getError();
        if (this.entidadView != null) {
            this.entidadView.hideProgress();

            if (errorMsg != null) {
                entidadView.onEntityError(errorMsg);
            } else {
                List<Entidad> items = entidadEvent.getEntidades();
                if (items != null && !items.isEmpty()) {
                    entidadView.setEntidades(items);
                }
            }
        }
    }
}
