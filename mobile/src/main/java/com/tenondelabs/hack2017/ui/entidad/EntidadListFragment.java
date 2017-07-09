package com.tenondelabs.hack2017.ui.entidad;

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
import com.tenondelabs.hack2017.data.model.Entidad;
import com.tenondelabs.hack2017.di.components.DaggerEntidadComponent;
import com.tenondelabs.hack2017.di.modules.EntidadModule;
import com.tenondelabs.hack2017.di.modules.LibsModule;
import com.tenondelabs.hack2017.di.modules.MainModule;
import com.tenondelabs.hack2017.ui.avances.AvanceActivity;
import com.tenondelabs.hack2017.ui.base.BaseActivity;
import com.tenondelabs.hack2017.ui.base.BaseFragment;
import com.tenondelabs.hack2017.ui.util.Util;

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
public class EntidadListFragment extends BaseFragment implements EntidadView,
		SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

	private static final String TAG = EntidadListFragment.class.getSimpleName();

	@Bind(R.id.container_entidad) FrameLayout container;
	@Bind(R.id.gridview_entidad) GridView mGridViewEntidad;
	@Bind(R.id.swipe_layout_entidad) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.progress_indicator_entidad) ProgressBar mProgressBar;

	@Inject EntidadAdapter adapter;
	@Inject EntidadPresenter entidadPresenter;

	private static EntidadListFragment entidadListFragment;

	public EntidadListFragment() { }

	public static EntidadListFragment newInstance() {
		if (entidadListFragment == null) {
			entidadListFragment = new EntidadListFragment();
		}

		return entidadListFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_entidad, container, false);
		ButterKnife.bind(this, view);

		mGridViewEntidad.setOnItemClickListener(this);
		mSwipeRefreshLayout.setOnRefreshListener(this);

		mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
				android.R.color.holo_orange_light, android.R.color.holo_red_light);

		setupInjection();
		setupGridView();

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		entidadPresenter.onResume();
		entidadPresenter.getEntidades();
	}

	@Override
	public void onPause() {
		super.onPause();
		entidadPresenter.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		entidadPresenter.onDestroy();
	}

	@Override
	public void onRefresh() {
		adapter.clearEntidades();
		entidadPresenter.getEntidades();

		if ( mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing() ) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
		if ( hasAdapter() ) {
			openAvanceActivity(position);
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
	public void setEntidades(List<Entidad> entidadList) {
		adapter.addEntidades(entidadList);
	}

	//Helper Methods
	private void setupInjection() {
		DaggerEntidadComponent
				.builder()
				.mainModule(new MainModule(getContext()))
				.libsModule(new LibsModule(this))
				.entidadModule(new EntidadModule(this))
				.build()
				.inject(this);
	}

	private void setupGridView() {
		mGridViewEntidad.setAdapter(adapter);
	}

	private boolean hasAdapter() {
		return (adapter != null);
	}

	private void openAvanceActivity(int position) {
		String entidadId = adapter.getItem(position).getInsId();

		Intent intent = new Intent(getActivity(), AvanceActivity.class);
		intent.putExtra(Util.CODIGO_ENTIDAD, entidadId);
		startActivity(intent, BaseActivity.ActivityAnimation.SLIDE_LEFT);
	}

}