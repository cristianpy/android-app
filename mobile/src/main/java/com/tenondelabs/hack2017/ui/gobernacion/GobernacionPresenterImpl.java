package com.tenondelabs.hack2017.ui.gobernacion;

import com.tenondelabs.hack2017.data.interactors.GobernacionInteractor;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.helpers.EventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Clase que implementa las acciones de las pantallas UI
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class GobernacionPresenterImpl implements GobernacionPresenter {

    private GobernacionView gobernacionView;
    private GobernacionInteractor gobernacionInteractor;
    private EventBus eventBus;

    public GobernacionPresenterImpl(GobernacionView gobernacionView, GobernacionInteractor gobernacionInteractor, EventBus eventBus) {
        this.gobernacionView = gobernacionView;
        this.gobernacionInteractor = gobernacionInteractor;
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
        this.gobernacionView = null;
    }

    @Override
    public void getGobernaciones() {
        if (this.gobernacionView != null) {
            gobernacionView.showProgress();
        }

        this.gobernacionInteractor.getGobernacionList();
    }

    @Override
    public void loadGobernaciones() {
        if (this.gobernacionView != null) {
            gobernacionView.showProgress();
        }

        this.gobernacionInteractor.loadGobernacionesFromStorage();
    }

    @Override
    @Subscribe
    public void onEventMainThread(GobernacionEvent ciudadEvent) {
        String errorMsg = ciudadEvent.getError();
        if (this.gobernacionView != null) {
            this.gobernacionView.hideProgress();

            if (errorMsg != null) {
                gobernacionView.onEntityError(errorMsg);
            } else {
                List<Gobernacion> items = ciudadEvent.getGobernaciones();
                if (items != null && !items.isEmpty()) {
                    gobernacionView.setGobernaciones(items);
                }
            }
        }
    }
}
