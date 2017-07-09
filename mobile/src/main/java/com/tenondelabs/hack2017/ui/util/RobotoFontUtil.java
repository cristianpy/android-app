package com.tenondelabs.hack2017.ui.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase Util para Roboto Font
 * Copyright 2017 TenondeLabs. All rights reserved
 */
public class RobotoFontUtil {

    private static Typeface typefaceRR;
    private static Typeface typefaceRL;

    public static Typeface getFontRobotoRegular(Context context){
        if (typefaceRR == null){
            typefaceRR = Typeface.createFromAsset(context.getAssets(),
                    "font/Roboto-Regular.ttf");
        }

        return typefaceRR;
    }

    public static Typeface getFontRobotoLigth(Context context){
        if (typefaceRL == null){
            typefaceRL = Typeface.createFromAsset(context.getAssets(),
                    "font/Roboto-Light.ttf");
        }

        return typefaceRL;
    }
}
