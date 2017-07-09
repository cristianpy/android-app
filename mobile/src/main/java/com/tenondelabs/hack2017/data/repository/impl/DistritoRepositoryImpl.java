package com.tenondelabs.hack2017.data.repository.impl;

import android.util.Log;

import com.tenondelabs.hack2017.data.model.Distrito;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.DistritoRepository;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.distrito.DistritoEvent;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class DistritoRepositoryImpl implements DistritoRepository {

    private TenondeApiClient client;
    private EventBus eventBus;
    private Realm realm;

    public DistritoRepositoryImpl(TenondeApiClient client, EventBus eventBus, Realm realm) {
        this.client = client;
        this.eventBus = eventBus;
        this.realm = realm;
    }

    @Override
    public void getDistritos() {
        Callback<List<Distrito>> listener = new Callback<List<Distrito>>() {
            @Override
            public void success(List<Distrito> distritoList) {
                postEvent(distritoList);
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

        client.getServiceDistrito().getDistritos().enqueue(listener);
    }

    @Override
    public void getDistritosFromStorage() {
//        realm.executeTransactionAsync()
        RealmResults<Distrito> gobernaciones = realm.where(Distrito.class)
                .findAll();
        Log.d("CiudadRepository", "CIU CANT: " + gobernaciones.size());
        if (gobernaciones.isLoaded()) {
            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveDistritosStorage(final List<Distrito> distritoList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                for (Distrito gobernacion : gobernacionList) {
//                    gobernacion = realm.createObject(Distrito.class);
                    realm.insert(distritoList);
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
        DistritoEvent event = new DistritoEvent();
        event.setError(error);
        eventBus.post(event);
    }

    private void postEvent(List<Distrito> items) {
        DistritoEvent event = new DistritoEvent();
        event.setDistritos(items);
        eventBus.post(event);
    }

}
