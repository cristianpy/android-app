package com.tenondelabs.hack2017.ui.avances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.share.widget.DeviceShareButton;
import com.facebook.share.widget.ShareButton;
import com.squareup.picasso.Picasso;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.data.model.Avance;
import com.tenondelabs.hack2017.ui.util.RobotoFontUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase que representa el Adaptador de un ListView
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class AvanceAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Avance> mAvances;



	public AvanceAdapter(Context context) {
		this.mContext = context;
		this.mAvances = new ArrayList<>();

		if (mContext != null) {
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}

	public void addAvances(List<Avance> avanceList){
		mAvances.addAll(avanceList);
		notifyDataSetChanged();
	}

	public void clearAvances(){
		mAvances.clear();
		notifyDataSetChanged();
	}

	public List<Avance> getAvances(){
		return mAvances;
	}

	public Avance getAvance(int position) {
		return mAvances.get(position);
	}

	//Patron ViewHolder
	public class ViewHolderCiudad {
		@Bind(R.id.img_avance) ImageView mImgAvance;
		@Bind(R.id.txt_justificacion) TextView mTxtJustificacion;
		@Bind(R.id.share_facebook) ShareButton share_facebook;
//		@Bind(R.id.share_twitter) ComposerView share_twitter;

		public ViewHolderCiudad(View view){
			ButterKnife.bind(this, view);
		}

	}

	@Override
	public int getCount() {
		return mAvances == null ? 0 : mAvances.size();
	}

	@Override
	public Object getItem(int position) {
		return mAvances.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (mAvances.get(position) == null) {
			return -1;
		}
		return mAvances.get(position).getId();
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolderCiudad viewHolder;

		if (view == null) {
			view = mInflater.inflate(R.layout.avance_list_item, viewGroup, false) ;
			viewHolder = new ViewHolderCiudad(view);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderCiudad) view.getTag();
		}

		Picasso.with(mContext)
			.load(mAvances.get(position).getImagen())
			.fit()
			.placeholder(R.drawable.ic_carrete_eventos_table)
			.error(R.drawable.ic_pin_drop_white_24dp)
			.into(viewHolder.mImgAvance);

		viewHolder.mTxtJustificacion.setTypeface(RobotoFontUtil.getFontRobotoRegular(mContext));
		viewHolder.mTxtJustificacion.setText(mAvances.get(position).getJustificacion());

		return view;
	}

}