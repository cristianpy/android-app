package com.tenondelabs.hack2017.di.modules;

import android.content.Context;

import com.tenondelabs.hack2017.data.interactors.AvanceInteractor;
import com.tenondelabs.hack2017.data.interactors.impl.AvanceInteractorImpl;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;
import com.tenondelabs.hack2017.data.repository.AvanceRepository;
import com.tenondelabs.hack2017.data.repository.impl.AvanceRepositoryImpl;
import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.ui.avances.AvanceAdapter;
import com.tenondelabs.hack2017.ui.avances.AvancePresenter;
import com.tenondelabs.hack2017.ui.avances.AvancePresenterImpl;
import com.tenondelabs.hack2017.ui.avances.AvanceView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
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
    AvanceInteractor provideAvanceInteractor(AvanceRepository ciudadRepository) {
        return new AvanceInteractorImpl(ciudadRepository);
    }

    @Provides
    @Singleton
    AvanceRepository provideAvanceRepository(TenondeApiClient client, EventBus eventBus, Realm realm) {
        return new AvanceRepositoryImpl(client, eventBus, realm);
    }

}
