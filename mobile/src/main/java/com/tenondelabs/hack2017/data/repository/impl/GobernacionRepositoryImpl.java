package com.tenondelabs.hack2017.data.repository.impl;

import com.tenondelabs.hack2017.data.model.DataSetGobernacion;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.GobernacionRepository;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionEvent;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class GobernacionRepositoryImpl implements GobernacionRepository {

    private TenondeApiClient client;
    private EventBus eventBus;
    private Realm realm;

    public GobernacionRepositoryImpl(TenondeApiClient client, EventBus eventBus, Realm realm) {
        this.client = client;
        this.eventBus = eventBus;
        this.realm = realm;
    }

    @Override
    public void getGobernaciones() {
        Callback<DataSetGobernacion> listener = new Callback<DataSetGobernacion>() {
            @Override
            public void success(DataSetGobernacion dataSet) {
                postEvent(dataSet.getGobernaciones());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                super.onFailure(call, t);
                postEvent(t.getLocalizedMessage());
            }

            @Override
            public void networkFailure(Throwable error) {
                super.networkFailure(error);
                postEvent(error.getLocalizedMessage());
            }
        };

        client.getServiceDepartamento().getGobernaciones().enqueue(listener);
    }

    @Override
    public void getGobernacionesFromStorage() {
        RealmResults<Gobernacion> gobernaciones = realm.where(Gobernacion.class)
                .findAll();
        if (gobernaciones.isLoaded()) {
            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveGobernacionesStorage(final List<Gobernacion> gobernacionList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(gobernacionList);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                postEvent(error.getLocalizedMessage());
            }
        });
    }

    private void postEvent(String error) {
        GobernacionEvent event = new GobernacionEvent();
        event.setError(error);
        eventBus.post(event);
    }

    private void postEvent(List<Gobernacion> items) {
        GobernacionEvent event = new GobernacionEvent();
        event.setGobernaciones(items);
        eventBus.post(event);
    }

}
