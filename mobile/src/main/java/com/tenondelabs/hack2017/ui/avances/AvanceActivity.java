package com.tenondelabs.hack2017.ui.avances;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.base.BaseActivity;
import com.tenondelabs.hack2017.ui.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Clase que representa a la pantalla de empresas
 * Copyright 2016 TenondeLabs Inc. All rights reserved
 */
public class AvanceActivity extends BaseActivity {

    private static final String TAG = AvanceActivity.class.getSimpleName();

    @Bind(R.id.toolbar) Toolbar toolbar;

    private AvanceListFragment avanceListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance);

        ButterKnife.bind(this);
        setToolbar();

        String dptoId = getIntent().getStringExtra(Util.CODIGO_DPTO);
        String entidadId = getIntent().getStringExtra(Util.CODIGO_ENTIDAD);

        if (!dptoId.isEmpty()) {
            setupAvanceFragmentByDeptoId(dptoId, savedInstanceState);
        } else if (!entidadId.isEmpty()) {
            setupAvanceFragmentByEntidadId(entidadId, savedInstanceState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish(ActivityAnimation.SLIDE_RIGHT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_avance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(ActivityAnimation.SLIDE_RIGHT);
                break;
//            case R.id.action_main:
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent,ActivityAnimation.SLIDE_RIGHT);
//                break;
        }

        return true;
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupAvanceFragmentByDeptoId(String dptoId, Bundle savedInstanceState){
        if (savedInstanceState == null) {
            avanceListFragment = AvanceListFragment.newInstance(dptoId);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_avance, avanceListFragment, Util.NOMBRE_AVANCE )
                    .commit();
        } else {
            if (avanceListFragment == null) {
                avanceListFragment = (AvanceListFragment) getSupportFragmentManager().findFragmentByTag(Util.NOMBRE_AVANCE);
                avanceListFragment.setDeptId(dptoId);
            }
        }
    }

    private void setupAvanceFragmentByEntidadId(String entidadId, Bundle savedInstanceState){
        if (savedInstanceState == null) {
            avanceListFragment = AvanceListFragment.newInstance(entidadId);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_avance, avanceListFragment, Util.NOMBRE_AVANCE )
                    .commit();
        } else {
            if (avanceListFragment == null) {
                avanceListFragment = (AvanceListFragment) getSupportFragmentManager().findFragmentByTag(Util.NOMBRE_AVANCE);
                avanceListFragment.setEntidadId(entidadId);
            }
        }
    }

}