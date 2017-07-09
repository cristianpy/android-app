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

    private GobernacionView gobernacionView;

    public ActividadModule(GobernacionView gobernacionView) {
        this.gobernacionView = gobernacionView;
    }

    @Provides
    @Singleton
    GobernacionView provideGobernacionView() {
        return this.gobernacionView;
    }

    @Provides
    @Singleton
    GobernacionPresenter provideGobernacionPresenter(GobernacionView ciudadView, GobernacionInteractor gobernacionInteractor, EventBus eventBus) {
        return new GobernacionPresenterImpl(ciudadView, gobernacionInteractor, eventBus);
    }

    @Provides
    GobernacionAdapter provideAdapter(Context context) {
        return new GobernacionAdapter(context);
    }

    @Provides
    @Singleton
    GobernacionInteractor provideGobernacionInteractor(GobernacionRepository ciudadRepository) {
        return new GobernacionInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    GobernacionRepository provideGobernacionRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new GobernacionRepositoryImpl(client, eventBus, realm);
    }

}
