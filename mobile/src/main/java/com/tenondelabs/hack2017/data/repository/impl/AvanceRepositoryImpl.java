package com.tenondelabs.hack2017.data.repository.impl;

import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.data.model.DataSet;
import com.tenondelabs.hack2017.data.model.DataSetAvance;
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
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
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
        Callback<DataSetAvance> listener = new Callback<DataSetAvance>() {
            @Override
            public void success(DataSetAvance dataSet) {
                postEvent(dataSet.getAvances());
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
        RealmResults<Avance> avances = realm.where(Avance.class)
                .findAll();
        if (avances.isLoaded()) {
            postEvent(avances);
        }
    }

    @Override
    public void saveAvanceStorage(final List<Avance> avanceList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insert(avanceList);
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
