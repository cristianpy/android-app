package com.tenondelabs.hack2017.ui.entidad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.data.model.Entidad;
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
public class EntidadAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Entidad> mEntidades;

	public EntidadAdapter(Context context) {
		this.mContext = context;
		this.mEntidades = new ArrayList<>();

		if (mContext != null) {
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}

	public void addEntidades(List<Entidad> gobernaciones){
		mEntidades.addAll(gobernaciones);
		notifyDataSetChanged();
	}

	public void clearEntidades(){
		mEntidades.clear();
		notifyDataSetChanged();
	}

	public List<Entidad> getEntidades(){
		return mEntidades;
	}

	public Entidad getEntidad(int position) {
		return mEntidades.get(position);
	}


	//Patron ViewHolder
	public class ViewHolderEntidad {
		@Bind(R.id.img_entidad) ImageView mImgEntidad;
		@Bind(R.id.txt_nombre_entidad) TextView mTxtNombreEntidad;

		public ViewHolderEntidad(View view){
			ButterKnife.bind(this, view);
		}

	}

	@Override
	public int getCount() {
		return mEntidades == null ? 0 : mEntidades.size();
	}

	@Override
	public Entidad getItem(int position) {
		return mEntidades.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (mEntidades.get(position) == null) {
			return -1;
		}

		return mEntidades.get(position).getId();
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolderEntidad viewHolder;

		if (view == null) {
			view = mInflater.inflate(R.layout.entidad_list_item, viewGroup, false);
			viewHolder = new ViewHolderEntidad(view);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderEntidad) view.getTag();
		}

//		Picasso.with(mContext)
//			.load(R.drawable.ic_account_balance_black_24dp)
//			.fit()
//			.into(viewHolder.mImgEntidad);

		Picasso.with(mContext)
				.load(mEntidades.get(position).getImagen())
				.fit()
				.placeholder(R.drawable.ic_account_balance_white_24dp)
				.error(R.drawable.ic_account_balance_white_24dp)
				.into(viewHolder.mImgEntidad);

		viewHolder.mTxtNombreEntidad.setTypeface(RobotoFontUtil.getFontRobotoRegular(mContext));
		viewHolder.mTxtNombreEntidad.setText(mEntidades.get(position).getNombre());

		return view;
	}

}