package com.tenondelabs.hack2017.ui.base;

/**
 * @author TenondeLabs
 * @version 0.0.1
 * Base interface for presenter of the pattern MVP
 * Copyright 2017 TenondeLabs. All rights reserved
 */
public interface Presenter {
    void onResume();
    void onPause();
    void onDestroy();
}
