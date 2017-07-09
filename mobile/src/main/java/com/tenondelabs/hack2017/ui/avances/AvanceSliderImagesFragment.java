package com.tenondelabs.hack2017.ui.avances;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.base.BaseFragment;
import com.tenondelabs.hack2017.ui.images.FullScreenImageActivity;
import com.tenondelabs.hack2017.ui.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;


public class AvanceSliderImagesFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener{

	private static final String TAG = AvanceSliderImagesFragment.class.getSimpleName();

	private static boolean active = false;

	@Bind(R.id.my_slider) SliderLayout mSlider;
	@Bind(R.id.custom_indicator) PagerIndicator mIndicator;
	@Bind(R.id.no_images) ImageView noImages;

	private Realm realm;
	private Long empresaId;

	public AvanceSliderImagesFragment() { }

	public static AvanceSliderImagesFragment newInstance(Long empresaId) {
		AvanceSliderImagesFragment empresaImagesFragment = new AvanceSliderImagesFragment();
		empresaImagesFragment.setEmpresaId(empresaId);

		return empresaImagesFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.images_slider, container, false);
		ButterKnife.bind(this, view);

		setupRealm();
//		loadImageToUIMain();
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ButterKnife.unbind(this);
		this.realm.close();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	private void setupRealm() {
		this.realm = Realm.getDefaultInstance();
	}


	@Override
	public void onSliderClick(BaseSliderView slider) {
		Intent intent = new Intent(getActivity(), FullScreenImageActivity.class);
		intent.putExtra(Util.IMAGE_URL,slider.getUrl());
		startActivity(intent);
    }

	@Override
	public void onStart() {
		super.onStart();
		active = true;
	}

	@Override
    public void onStop() {
        super.onStop();
        mSlider.stopAutoCycle();
		active = false;
    }


	public void startSlider() {
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(active && mSlider!=null) mSlider.startAutoCycle();
			}
		}, 3000);
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
}