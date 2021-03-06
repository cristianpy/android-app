package com.tenondelabs.hack2017.data.repository.impl;

import com.tenondelabs.hack2017.data.model.Actividad;
import com.tenondelabs.hack2017.data.remote.Callback;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.ActividadRepository;
import com.tenondelabs.hack2017.helpers.EventBus;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
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
            public void success(List<Actividad> actividadList) {
//                postEvent(actividadList);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                super.onFailure(call, t);
//                postEvent(t.getLocalizedMessage());
            }

            @Override
            public void networkFailure(Throwable error) {
                super.networkFailure(error);
//                postEvent(error.getLocalizedMessage());
            }
        };

//        client.getService().getActividades().enqueue(listener);
    }

    @Override
    public void getActividadesFromStorage() {
//        realm.executeTransactionAsync()
        RealmResults<Actividad> actividades = realm.where(Actividad.class)
                .findAll();
        if (actividades.isLoaded()) {
//            postEvent(gobernaciones);
        }
    }

    @Override
    public void saveActividadesStorage(final List<Actividad> actividadList) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                for (Actividad gobernacion : gobernacionList) {
//                    gobernacion = realm.createObject(Actividad.class);
                    realm.insert(actividadList);
//                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
//                postEvent(error.getLocalizedMessage());
            }
        });
    }

//    private void postEvent(String error) {
//        ActividadEvent event = new ActividadEvent();
//        event.setError(error);
//        eventBus.post(event);
//    }
//
//    private void postEvent(List<Actividad> items) {
//        ActividadEvent event = new ActividadEvent();
//        event.setActividades(items);
//        eventBus.post(event);
//    }

}
