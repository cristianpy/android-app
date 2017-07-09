package com.tenondelabs.hack2017.di.modules;

import android.content.Context;

import com.tenondelabs.hack2017.data.interactors.DistritoInteractor;
import com.tenondelabs.hack2017.data.interactors.impl.DistritoInteractorImpl;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.DistritoRepository;
import com.tenondelabs.hack2017.data.repository.impl.DistritoRepositoryImpl;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.distrito.DistritoAdapter;
import com.tenondelabs.hack2017.ui.distrito.DistritoPresenter;
import com.tenondelabs.hack2017.ui.distrito.DistritoPresenterImpl;
import com.tenondelabs.hack2017.ui.distrito.DistritoView;

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
public class DistritoModule {

    private DistritoView distritoView;

    public DistritoModule(DistritoView distritoView) {
        this.distritoView = distritoView;
    }

    @Provides
    @Singleton
    DistritoView provideDistritoView() {
        return this.distritoView;
    }

    @Provides
    @Singleton
    DistritoPresenter provideDistritoPresenter(DistritoView ciudadView, DistritoInteractor distritoInteractor, EventBus eventBus) {
        return new DistritoPresenterImpl(ciudadView, distritoInteractor, eventBus);
    }

    @Provides
    DistritoAdapter provideAdapter(Context context) {
        return new DistritoAdapter(context);
    }

    @Provides
    @Singleton
    DistritoInteractor provideDistritoInteractor(DistritoRepository ciudadRepository) {
        return new DistritoInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    DistritoRepository provideDistritoRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new DistritoRepositoryImpl(client, eventBus, realm);
    }

}
