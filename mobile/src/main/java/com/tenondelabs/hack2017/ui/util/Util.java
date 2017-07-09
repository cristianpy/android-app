package com.tenondelabs.hack2017.ui.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Rodrigo Garcete
 * @version 0.0.1
 * Copyright 2016 TenondeLabs Inc. All rights reserved
 */
public class Util {

    //avances
    public static final String CODIGO_AVANCE       = "CODIGO_AVANCE";
    public static final String NOMBRE_AVANCE       = "NOMBRE_AVANCE";
    public static final String IMAGE_AVANCE        = "IMAGE_AVANCE";
    public static final String IMAGE_URL           = "IMAGE_URL";

    //Departamentos
    public static final String CODIGO_DPTO          = "CODIGO_DPTO";

    //Entidad
    public static final String CODIGO_ENTIDAD       = "CODIGO_ENTIDAD";

    public static String removeAccent(String text){
        String result = Normalizer.normalize(text, Normalizer.Form.NFD);
        return result.replaceAll("[^\\p{ASCII}]", "");
    }

    public static String replacePhone(String phone) {
        String result = phone.replace("(", "");
        result = result.replace(")", "");
        result = result.replace(".", "");
        result = result.replace("-", "");
        return result;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager mConMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return mConMgr.getActiveNetworkInfo() != null
                && mConMgr.getActiveNetworkInfo().isAvailable()
                && mConMgr.getActiveNetworkInfo().isConnected();
    }

    public static void isNetworkAvailable(final Handler handler, final int timeout, final Context context) {
        // ask fo message '0' (not connected) or '1' (connected) on 'handler'
        // the answer must be send before before within the 'timeout' (in milliseconds)

        new Thread() {
            private boolean responded = false;
            @Override
            public void run() {
                // set 'responded' to TRUE if is able to connect with google mobile (responds fast)
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
                            urlc.setConnectTimeout(timeout); //choose your own timeframe
                            urlc.connect();
                            responded = (urlc.getResponseCode() == 200);
                        } catch (IOException e) {
                        }
                    }
                }.start();

                try {
                    int waited = 0;
                    boolean online = isOnline(context);
                    while(!responded && (waited < timeout) && online) {
                        sleep(100);
                        if(!responded ) {
                            waited += 100;
                        }
                    }
                }
                catch(InterruptedException e) {} // do nothing
                finally {
                    Log.i("internet",responded+"");
                    if (!responded) { handler.sendEmptyMessage(0); }
                    else { handler.sendEmptyMessage(1); }
                }
            }
        }.start();
    }


    public static Double formatoValor(String valor){
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.##", simbolo);
        Number numero = 0;

        try{
            numero = formato.parse(valor);
        } catch (ParseException e){
            e.printStackTrace();
        }

        return numero.doubleValue();
    }

    public static String formatoValor(Double valor){
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.##", simbolo);

        return formato.format(valor);
    }

    public static String formatoFechaDDMMAAAA(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy") ;
        return formato.format(fecha);
    }
    public static String formatoFechaDDMMAAAAHHMM(Date fecha, String hora){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy "+formatoHoraHHMM(hora)) ;
        return formato.format(fecha);
    }
    public static String formatoHoraHHMM(String hora){
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm") ;
        //2000-01-01T13:09:00.000Z
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date d = null;
        try {
            d = formatoOriginal.parse(hora);
        } catch (ParseException e) {
        }
        return formatoHora.format(d);
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static int[] horaStringToIntArray(String hora) {
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date d = formatoOriginal.parse(hora);
            int[] time = new int[] {toCalendar(d).get(Calendar.HOUR_OF_DAY),toCalendar(d).get(Calendar.MINUTE)};
            return time;
        } catch (ParseException e) {
            return new int[]{12,0};
        }
    }

}