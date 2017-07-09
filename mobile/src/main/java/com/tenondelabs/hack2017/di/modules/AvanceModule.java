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
public class AvanceModule {

    private AvanceView avanceView;

    public AvanceModule(AvanceView avanceView) {
        this.avanceView = avanceView;
    }

    @Provides
    @Singleton
    AvanceView provideAvanceView() {
        return this.avanceView;
    }

    @Provides
    @Singleton
    AvancePresenter provideAvancePresenter(AvanceView ciudadView, AvanceInteractor avanceInteractor, EventBus eventBus) {
        return new AvancePresenterImpl(ciudadView, avanceInteractor, eventBus);
    }

    @Provides
    AvanceAdapter provideAdapter(Context context) {
        return new AvanceAdapter(context);
    }

    @Provides
    @Singleton
    AvanceInteractor provideGobernacionInteractor(AvanceRepository ciudadRepository) {
        return new AvanceInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    AvanceRepository provideAvanceRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new AvanceRepositoryImpl(client, eventBus, realm);
    }

}
