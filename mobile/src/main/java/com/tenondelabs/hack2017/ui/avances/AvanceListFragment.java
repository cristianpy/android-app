package com.tenondelabs.hack2017.ui.avances;

import android.content.Context;
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
import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.di.components.DaggerAvanceComponent;
import com.tenondelabs.hack2017.di.modules.AvanceModule;
import com.tenondelabs.hack2017.di.modules.LibsModule;
import com.tenondelabs.hack2017.di.modules.MainModule;
import com.tenondelabs.hack2017.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author TenondeLabs
 * @version 0.1
 * Clase que representa un Fragment de una Pantalla
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class AvanceListFragment extends BaseFragment implements AvanceView,
		SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

	private static final String TAG = AvanceListFragment.class.getSimpleName();

	@Bind(R.id.container_avances) FrameLayout container;
	@Bind(R.id.gridview_avances) GridView mGridViewAvances;
	@Bind(R.id.swipe_layout_avances) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.progress_indicator_avances) ProgressBar mProgressBar;

	@Inject AvanceAdapter adapter;
	@Inject AvancePresenter ciudadPresenter;

	private static AvanceListFragment gobernacionListFragment;

	private OnFragmentInteractionListener listener;

	public AvanceListFragment() { }

	public static AvanceListFragment newInstance() {
		if (gobernacionListFragment == null) {
			gobernacionListFragment = new AvanceListFragment();
		}

		return gobernacionListFragment;
	}

	public static AvanceListFragment newInstance(String action) {
		AvanceListFragment avanceListFragment = new AvanceListFragment();

		return avanceListFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_avance, container, false);
		ButterKnife.bind(this, view);

		mGridViewAvances.setOnItemClickListener(this);
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
		ciudadPresenter.getAvances();
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
		ciudadPresenter.getAvances();
//        loadGobernaciones();

		if ( mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing() ) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}

	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			listener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
		if ( hasAdapter() ) {
			openCategoriaActivity(position);
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
	public void setAvances(List<Avance> avanceList) {
		adapter.addAvances(avanceList);
	}

	//Helper Methods
	private void setupInjection() {
		DaggerAvanceComponent
				.builder()
				.mainModule(new MainModule(getContext()))
				.libsModule(new LibsModule(this))
				.avanceModule(new AvanceModule(this))
				.build()
				.inject(this);
	}

	private void setupGridView() {
//		if (getAction() != null) {
//			adapter.setAction(getAction());
//		}
		mGridViewAvances.setAdapter(adapter);
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

	public interface OnFragmentInteractionListener { }

}