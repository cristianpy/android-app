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
public class DepartamentoModule {

    private DepartamentoView departamentoView;

    public DepartamentoModule(DepartamentoView departamentoView) {
        this.departamentoView = departamentoView;
    }

    @Provides
    @Singleton
    DepartamentoView provideDepartamentoView() {
        return this.departamentoView;
    }

    @Provides
    @Singleton
    DepartamentoPresenter provideDepartamentoPresenter(DepartamentoView ciudadView, DepartamentoInteractor departamentoInteractor, EventBus eventBus) {
        return new DepartamentoPresenterImpl(ciudadView, departamentoInteractor, eventBus);
    }

    @Provides
    DepartamentoAdapter provideAdapter(Context context) {
        return new DepartamentoAdapter(context);
    }

    @Provides
    @Singleton
    DepartamentoInteractor provideDepartamentoInteractor(DepartamentoRepository ciudadRepository) {
        return new DepartamentoInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    DepartamentoRepository provideDepartamentoRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new DepartamentoRepositoryImpl(client, eventBus, realm);
    }

}
