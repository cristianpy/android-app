package com.tenondelabs.hack2017.data.repository.impl;

import android.util.Log;

import com.tenondelabs.hack2017.data.model.Actividad;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.ActividadRepository;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.gobernacion.ActividadEvent;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class ActividadRepositoryImpl implements ActividadRepository {

    private TenondeApiClient client;
    private EventBus eventBus;
    private Realm realm;

    public ActividadRepositoryImpl(TenondeApiClient client, EventBus eventBus, Realm realm) {
        this.client = client;
        this.eventBus = eventBus;
        this.realm = realm;
    }

    @Override
    public void getActividades() {
        Callback<List<Actividad>> listener = new Callback<List<Actividad>>() {
            @Override
            public void success(List<Actividad> ciudadList) {
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

        client.getService().getActividades().enqueue(listener);
    }

    @Override
    public void getActividadesFromStorage() {
//        realm.executeTransactionAsync()
        RealmResults<Actividad> gobernaciones = realm.where(Actividad.class)
                .findAll();
        Log.d("CiudadRepository", "CIU CANT: " + gobernaciones.size());
        if (gobernaciones.isLoaded()) {
            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveActividadesStorage(final List<Actividad> gobernacionList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                for (Actividad gobernacion : gobernacionList) {
//                    gobernacion = realm.createObject(Actividad.class);
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
        ActividadEvent event = new ActividadEvent();
        event.setError(error);
        eventBus.post(event);
    }

    private void postEvent(List<Actividad> items) {
        ActividadEvent event = new ActividadEvent();
        event.setActividades(items);
        eventBus.post(event);
    }

}
