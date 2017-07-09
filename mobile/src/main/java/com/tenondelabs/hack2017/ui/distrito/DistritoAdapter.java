package com.tenondelabs.hack2017.ui.distrito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.data.model.Distrito;
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
public class DistritoAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Distrito> mDistritos;
//	private String action;
//	private Realm realm;

	public DistritoAdapter(Context context) {
		this.mContext = context;
		this.mDistritos = new ArrayList<>();

		if (mContext != null) {
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}

	public void addDistritos(List<Distrito> distritos){
		mDistritos.addAll(distritos);
		notifyDataSetChanged();
	}

	public void clearDistritos(){
		mDistritos.clear();
		notifyDataSetChanged();
	}

	public List<Distrito> getDistritos(){
		return mDistritos;
	}

	public Distrito getDistrito(int position) {
		return mDistritos.get(position);
	}

//	public void setAction(String accion) {
//		this.action = accion;
//	}

	//Patron ViewHolder
	public class ViewHolderDistrito {
		@Bind(R.id.img_distrito) ImageView mImgDistrito;
		@Bind(R.id.txt_nombre_distrito) TextView mTxtNombreDistrito;
		@Bind(R.id.img_today) ImageView mImgToday;

		public ViewHolderDistrito(View view){
			ButterKnife.bind(this, view);
		}

	}

	@Override
	public int getCount() {
		return mDistritos == null ? 0 : mDistritos.size();
	}

	@Override
	public Object getItem(int position) {
		return mDistritos.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (mDistritos.get(position) == null) {
			return -1;
		}
		return mDistritos.get(position).getId();
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolderDistrito viewHolder;

		if (view == null) {
			view = mInflater.inflate(R.layout.gobernacion_list_item, viewGroup, false) ;
			viewHolder = new ViewHolderDistrito(view);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderDistrito) view.getTag();
		}

		Picasso.with(mContext)
				.load(mDistritos.get(position).getImagen())
				.fit()
//				.placeholder(R.drawable.ic_carrete_eventos_table)
//				.error(R.drawable.ic_pin_drop_white_24dp)
				.into(viewHolder.mImgDistrito);

		viewHolder.mTxtNombreDistrito.setTypeface(RobotoFontUtil.getFontRobotoRegular(mContext));
		viewHolder.mTxtNombreDistrito.setText(mDistritos.get(position).getNombre());

//		if (action!=null){
//			checkFavorites(mDistritos.get(position).getId(),viewHolder);
//		}

		return view;
	}

//	private void setupRealm() {
//		realm = Realm.getDefaultInstance();
//	}

//	private void checkFavorites(long distritoId, ViewHolderDistrito viewHolder) {
//		Calendar auxCalendar = Calendar.getInstance();
//		auxCalendar.set(Calendar.HOUR_OF_DAY,0);
//		auxCalendar.set(Calendar.MINUTE,0);
//		auxCalendar.set(Calendar.SECOND,0);
//		auxCalendar.set(Calendar.MILLISECOND,0);
//		setupRealm();
//		Long count = 0l;
//		if (action.compareTo(Util.EVENTO_BY_CIUDAD) == 0){
//			count = realm.where(Evento.class)
//					.equalTo("fecha",auxCalendar.getTime())
//					.equalTo("favorito", true)
//					.equalTo("distritoId", distritoId)
//					.count();
//		}else if(action.compareTo(Util.PROMO_BY_CIUDAD) == 0){
//			count = realm.where(Promocion.class)
//					.lessThanOrEqualTo("fechaInicio",auxCalendar.getTime())
//					.greaterThanOrEqualTo("fechaFin",auxCalendar.getTime())
//					.equalTo("favorito", true)
//					.equalTo("distritoId", distritoId)
//					.count();
//		}
//		realm.close();
//		viewHolder.mImgToday.setVisibility(count>0?View.VISIBLE:View.GONE);
//	}

}