package com.tenondelabs.hack2017.ui.base;

/**
 * @author TenondeLabs
 * @version 0.0.1
 * Base interface for View of the pattern MVP
 * Copyright 2017 TenondeLabs. All rights reserved
 */
public interface BaseView {
    void showProgress();
    void hideProgress();
    void onEntityError(String error);
}
