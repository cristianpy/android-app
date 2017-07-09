package com.tenondelabs.hack2017.ui.distrito;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Rodrigo Garcete
 * @version 0.1
 * Clase que representa un Fragment de una Pantalla
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class DistritoListFragment extends BaseFragment implements DistritoView,
		SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

	private static final String TAG = DistritoListFragment.class.getSimpleName();

	@Bind(R.id.container_gobernacion) FrameLayout container;
	@Bind(R.id.gridview_gobernacion) GridView mGridViewGobernacion;
	@Bind(R.id.swipe_layout_gobernacion) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.progress_indicator_gobernacion) ProgressBar mProgressBar;

	@Inject
	DistritoAdapter adapter;
	@Inject
	DistritoPresenter ciudadPresenter;
//	@Inject Realm realm;

	private static DistritoListFragment gobernacionListFragment;
	private String action;

	public DistritoListFragment() { }

	public static DistritoListFragment getInstance() {
		if (gobernacionListFragment == null) {
			gobernacionListFragment = new DistritoListFragment();
		}

		return gobernacionListFragment;
	}

	public static DistritoListFragment newInstance(String action) {
		DistritoListFragment ciudadListFragment = new DistritoListFragment();
		ciudadListFragment.setAction(action);

		return ciudadListFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_gobernacion, container, false);
		ButterKnife.bind(this, view);

		mGridViewGobernacion.setOnItemClickListener(this);
		mSwipeRefreshLayout.setOnRefreshListener(this);

		mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
				android.R.color.holo_orange_light, android.R.color.holo_red_light);

		setupInjection();
		setupGridView();
		//loadCiudades(); **Moved to onResume to refresh on back to activity**

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		ciudadPresenter.onResume();
		ciudadPresenter.getGobernaciones();
//		loadGobernaciones();
	}

	@Override
	public void onPause() {
		super.onPause();
		ciudadPresenter.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ciudadPresenter.onDestroy();
//		realm.close();
	}

	@Override
	public void onRefresh() {
		adapter.clearGobernaciones();
		ciudadPresenter.getGobernaciones();
//        loadGobernaciones();

		if ( mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing() ) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
		if ( hasAdapter() ) {
			if (getAction() != null) {
				openActionActivity(position, getAction());
			} else {
				openCategoriaActivity(position);
			}
		}
	}

	@Override
	public void showProgress() {
		mProgressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgress() {
		mProgressBar.setVisibility(View.GONE);
	}

	@Override
	public void onEntityError(String error) {
		Snackbar.make(container, error, Snackbar.LENGTH_LONG).show();
	}

	@Override
	public void setGobernaciones(List<Gobernacion> gobernacionList) {
		adapter.addGobernaciones(gobernacionList);
	}

	//Helper Methods
	private void setupInjection() {
//		DaggerCiudadComponent
//				.builder()
//				.mainModule(new MainModule(getContext()))
//				.libsModule(new LibsModule(this))
//				.ciudadModule(new CiudadModule(this))
//				.build()
//				.inject(this);
	}

	private void setupGridView() {
//		if (getAction() != null) {
//			adapter.setAction(getAction());
//		}
		mGridViewGobernacion.setAdapter(adapter);
	}

//	private void loadGobernaciones() {
//		RealmResults<Gobernacion> results = realm.where(Gobernacion.class).findAll();
//
//		hideProgress();
//
//		if (!results.isEmpty()) {
//			adapter.clearGobernaciones();
//			adapter.addGobernaciones(results);
//		} else {
//			Snackbar.make(container, "No es posible cargar Cuidades", Snackbar.LENGTH_LONG).show();
//		}
//	}

	private boolean hasAdapter() {
		return (adapter != null);
	}

	private void openCategoriaActivity(int position) {
		long ciudadId = adapter.getItemId(position);

//		Intent intent = new Intent(getActivity(), CategoriaActivity.class);
//		intent.putExtra(Util.CODIGO_CIUDAD, ciudadId);
//		startActivity(intent, BaseActivity.ActivityAnimation.SLIDE_LEFT);
	}

	private void openActionActivity(int position, String action) {
		long ciudadId = adapter.getItemId(position);
		Intent intent;

//		if (action.compareTo(Util.EVENTO_BY_CIUDAD) == 0) {
//			intent = new Intent(getActivity(), EventoActivity.class);
//		} else if (action.compareTo(Util.PROMO_BY_CIUDAD) == 0) {
//			intent = new Intent(getActivity(), PromocionActivity.class);
//		} else {
//			intent = new Intent(getActivity(), CategoriaActivity.class);
//		}
//
//		intent.putExtra(Util.CODIGO_CIUDAD, ciudadId);
//		startActivity(intent, BaseActivity.ActivityAnimation.SLIDE_LEFT);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}