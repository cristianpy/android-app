package com.tenondelabs.hack2017.data.repository.impl;

import android.util.Log;

import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.EntidadRepository;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.entidad.EntidadEvent;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class EntidadRepositoryImpl implements EntidadRepository {

    private TenondeApiClient client;
    private EventBus eventBus;
    private Realm realm;

    public EntidadRepositoryImpl(TenondeApiClient client, EventBus eventBus, Realm realm) {
        this.client = client;
        this.eventBus = eventBus;
        this.realm = realm;
    }

    @Override
    public void getEntidades() {
        Callback<List<Entidad>> listener = new Callback<List<Entidad>>() {
            @Override
            public void success(List<Entidad> ciudadList) {
                postEvent(ciudadList);
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

        client.getService().getEntidades().enqueue(listener);
    }

    @Override
    public void getEntidadesFromStorage() {
//        realm.executeTransactionAsync()
        RealmResults<Entidad> gobernaciones = realm.where(Entidad.class)
                .findAll();
        Log.d("CiudadRepository", "CIU CANT: " + gobernaciones.size());
        if (gobernaciones.isLoaded()) {
            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveEntidadesStorage(final List<Entidad> gobernacionList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                for (Entidad gobernacion : gobernacionList) {
//                    gobernacion = realm.createObject(Entidad.class);
                    realm.insert(gobernacionList);
//                }
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
        EntidadEvent event = new EntidadEvent();
        event.setError(error);
        eventBus.post(event);
    }

    private void postEvent(List<Entidad> items) {
        EntidadEvent event = new EntidadEvent();
        event.setEntidades(items);
        eventBus.post(event);
    }

}
