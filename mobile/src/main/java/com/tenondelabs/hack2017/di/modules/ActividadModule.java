package com.tenondelabs.hack2017.di.modules;

import android.content.Context;

import com.tenondelabs.hack2017.data.interactors.GobernacionInteractor;
import com.tenondelabs.hack2017.data.interactors.impl.GobernacionInteractorImpl;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.GobernacionRepository;
import com.tenondelabs.hack2017.data.repository.impl.GobernacionRepositoryImpl;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionAdapter;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionPresenter;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionPresenterImpl;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Module
public class ActividadModule {

    private ActividadView actidadView;

    public ActividadModule(ActividadView actividadView) {
        this.actividadView = actividadView;
    }

    @Provides
    @Singleton
    ActividadView provideActividadView() {
        return this.actividadView;
    }

    @Provides
    @Singleton
    ActividadPresenter provideActividadPresenter(ActividadView ciudadView, ActividadInteractor actividadInteractor, EventBus eventBus) {
        return new ActividadPresenterImpl(ciudadView, actividadInteractor, eventBus);
    }

    @Provides
    ActividadAdapter provideAdapter(Context context) {
        return new ActividadAdapter(context);
    }

    @Provides
    @Singleton
    ActividadInteractor provideActividadInteractor(ActividadRepository ciudadRepository) {
        return new ActividadInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    ActividadRepository provideActividadRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new ActividadRepositoryImpl(client, eventBus, realm);
    }

}
