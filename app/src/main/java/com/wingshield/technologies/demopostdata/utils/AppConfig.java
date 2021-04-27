package com.wingshield.technologies.demopostdata.utils;

import android.content.Context;



import java.text.DecimalFormat;

public class AppConfig {


    public static String ASSET_URL = "https://jsonplaceholder.typicode.com/";
    public static String BASE_URL = "https://gorest.co.in/public-api/";

    public static String TAG = "AppConfig";
    public static String TOKEN_ID = "Bearer aa15d6ec5ed47adabb395dd63a1c52e42fba1fc084ff91bccc1177a1140363f0";





    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static int convertDpToPx(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
