package com.tenondelabs.hack2017.ui.avances;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class AvanceDetailActivity extends BaseActivity
        implements OnMapReadyCallback {

    private static final String TAG = AvanceDetailActivity.class.getSimpleName();

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.container_empresa_detail) LinearLayout mContainer;
    @Bind(R.id.fragment_avance_images) FrameLayout mFrameImage;

    private static String AVANCE_NOMBRE;
    private static String AVANCE_DIRECCION;

    private Bundle bundle;
    private LatLng myPosition;
    private GoogleMap mGoogleMap;
    private AvanceSliderImagesFragment avanceSliderImagesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_avance);

        ButterKnife.bind(this);
        setToolbar();
        setGoogleMaps();
    }

    boolean isTextViewClicked = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (avanceSliderImagesFragment != null) avanceSliderImagesFragment.startSlider();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            finish(ActivityAnimation.SLIDE_RIGHT);
            return true;
        }
//        if (itemId == R.id.action_main){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent,ActivityAnimation.SLIDE_RIGHT);
//        }

        return super.onOptionsItemSelected(item);
    }

    private void setToolbar(){
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(AVANCE_NOMBRE);
        }
    }

    private void setGoogleMaps() {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mGoogleMap = googleMap;
        // Add a circle
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill
        this.mGoogleMap.addCircle(new CircleOptions()
                .center(myPosition)
                .radius(100)
                .fillColor(shadeColor)
                .strokeColor(strokeColor)
                .strokeWidth(8));

        MarkerOptions markerOptions = new MarkerOptions()
                .title(AVANCE_NOMBRE)
                .snippet(AVANCE_DIRECCION)
                .position(myPosition)
                .visible(true);

        Marker marker = mGoogleMap.addMarker(markerOptions);
        marker.showInfoWindow();

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 16));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mGoogleMap.setMyLocationEnabled(true);
    }

}