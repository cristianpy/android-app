package com.tenondelabs.hack2017.ui.gobernacion;

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
import com.tenondelabs.hack2017.di.components.DaggerGobernacionComponent;
import com.tenondelabs.hack2017.di.modules.GobernacionModule;
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
public class GobernacionListFragment extends BaseFragment implements GobernacionView,
		SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

	private static final String TAG = GobernacionListFragment.class.getSimpleName();

	@Bind(R.id.container_gobernacion) FrameLayout container;
	@Bind(R.id.gridview_gobernacion) GridView mGridViewGobernacion;
	@Bind(R.id.swipe_layout_gobernacion) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.progress_indicator_gobernacion) ProgressBar mProgressBar;

	@Inject GobernacionAdapter adapter;
	@Inject GobernacionPresenter ciudadPresenter;

	private static GobernacionListFragment gobernacionListFragment;
	private String action;

	public GobernacionListFragment() { }

	public static GobernacionListFragment newInstance() {
		if (gobernacionListFragment == null) {
			gobernacionListFragment = new GobernacionListFragment();
		}

		return gobernacionListFragment;
	}

	public static GobernacionListFragment newInstance(String action) {
		GobernacionListFragment ciudadListFragment = new GobernacionListFragment();
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

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		ciudadPresenter.onResume();
		ciudadPresenter.getGobernaciones();
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
	}

	@Override
	public void onRefresh() {
		adapter.clearGobernaciones();
		ciudadPresenter.getGobernaciones();

		if ( mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing() ) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
		if (hasAdapter() ) {
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
	public void setGobernaciones(List<Gobernacion> gobernacionList) {
		adapter.addGobernaciones(gobernacionList);
	}

	//Helper Methods
	private void setupInjection() {
		DaggerGobernacionComponent
				.builder()
				.mainModule(new MainModule(getContext()))
				.libsModule(new LibsModule(this))
				.gobernacionModule(new GobernacionModule(this))
				.build()
				.inject(this);
	}

	private void setupGridView() {
		mGridViewGobernacion.setAdapter(adapter);
	}

	private boolean hasAdapter() {
		return (adapter != null);
	}

	private void openAvanceActivity(int position) {
		long departamentoId = adapter.getItemId(position);

		Intent intent = new Intent(getActivity(), AvanceActivity.class);
		intent.putExtra(Util.CODIGO_AVANCE, departamentoId);
		startActivity(intent, BaseActivity.ActivityAnimation.SLIDE_LEFT);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}