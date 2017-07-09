package com.tenondelabs.hack2017.data.repository.impl;

import android.util.Log;

import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.AvanceRepository;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.avances.AvanceEvent;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class AvanceRepositoryImpl implements AvanceRepository {

    private TenondeApiClient client;
    private EventBus eventBus;
    private Realm realm;

    public AvanceRepositoryImpl(TenondeApiClient client, EventBus eventBus, Realm realm) {
        this.client = client;
        this.eventBus = eventBus;
        this.realm = realm;
    }

    @Override
    public void getAvances() {
        Callback<List<Avance>> listener = new Callback<List<Avance>>() {
            @Override
            public void success(List<Avance> ciudadList) {
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

        client.getService().getAvances().enqueue(listener);
    }

    @Override
    public void getAvancesFromStorage() {
//        realm.executeTransactionAsync()
        RealmResults<Avance> gobernaciones = realm.where(Avance.class)
                .findAll();
        Log.d("CiudadRepository", "CIU CANT: " + gobernaciones.size());
        if (gobernaciones.isLoaded()) {
            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveAvanceStorage(final List<Avance> avanceList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                for (Avance gobernacion : gobernacionList) {
//                    gobernacion = realm.createObject(Avance.class);
                    realm.insert(avanceList);
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
        AvanceEvent event = new AvanceEvent();
        event.setError(error);
        eventBus.post(event);
    }

    private void postEvent(List<Avance> items) {
        AvanceEvent event = new AvanceEvent();
        event.setAvances(items);
        eventBus.post(event);
    }

}
