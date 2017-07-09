package com.tenondelabs.hack2017.ui.gobernacion;

import android.content.Context;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.data.model.Gobernacion;
import com.tenondelabs.hack2017.ui.util.RobotoFontUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Clase que representa el Adaptador de un ListView
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public class GobernacionAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Gobernacion> mGobernaciones;
//	private String action;
//	private Realm realm;

	public GobernacionAdapter(Context context) {
		this.mContext = context;
		this.mGobernaciones = new ArrayList<>();

		if (mContext != null) {
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}

	public void addGobernaciones(List<Gobernacion> gobernaciones){
		mGobernaciones.addAll(gobernaciones);
		notifyDataSetChanged();
	}

	public void clearGobernaciones(){
		mGobernaciones.clear();
		notifyDataSetChanged();
	}

	public List<Gobernacion> getGobernaciones(){
		return mGobernaciones;
	}

	public Gobernacion getGobernacion(int position) {
		return mGobernaciones.get(position);
	}

//	public void setAction(String accion) {
//		this.action = accion;
//	}

	//Patron ViewHolder
	public class ViewHolderCiudad {
		@Bind(R.id.img_ciudad) ImageView mImgCiudad;
		@Bind(R.id.txt_nombre_ciudad) TextView mTxtNombreCiudad;
		@Bind(R.id.img_today) ImageView mImgToday;

		public ViewHolderCiudad(View view){
			ButterKnife.bind(this, view);
		}

	}

	@Override
	public int getCount() {
		return mGobernaciones == null ? 0 : mGobernaciones.size();
	}

	@Override
	public Object getItem(int position) {
		return mGobernaciones.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (mGobernaciones.get(position) == null) {
			return -1;
		}
		return mGobernaciones.get(position).getId();
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolderCiudad viewHolder;

		if (view == null) {
			view = mInflater.inflate(R.layout.gobernacion_list_item, viewGroup, false) ;
			viewHolder = new ViewHolderCiudad(view);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderCiudad) view.getTag();
		}

		Picasso.with(mContext)
				.load(mGobernaciones.get(position).getImagen())
				.fit()
//				.placeholder(R.drawable.ic_carrete_eventos_table)
//				.error(R.drawable.ic_pin_drop_white_24dp)
				.into(viewHolder.mImgCiudad);

		viewHolder.mTxtNombreCiudad.setTypeface(RobotoFontUtil.getFontRobotoRegular(mContext));
		viewHolder.mTxtNombreCiudad.setText(mGobernaciones.get(position).getNombre());

//		if (action!=null){
//			checkFavorites(mGobernaciones.get(position).getId(),viewHolder);
//		}

		return view;
	}

//	private void setupRealm() {
//		realm = Realm.getDefaultInstance();
//	}

//	private void checkFavorites(long ciudadId, ViewHolderCiudad viewHolder) {
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
//					.equalTo("ciudadId", ciudadId)
//					.count();
//		}else if(action.compareTo(Util.PROMO_BY_CIUDAD) == 0){
//			count = realm.where(Promocion.class)
//					.lessThanOrEqualTo("fechaInicio",auxCalendar.getTime())
//					.greaterThanOrEqualTo("fechaFin",auxCalendar.getTime())
//					.equalTo("favorito", true)
//					.equalTo("ciudadId", ciudadId)
//					.count();
//		}
//		realm.close();
//		viewHolder.mImgToday.setVisibility(count>0?View.VISIBLE:View.GONE);
//	}

}