package com.hope.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @anthor FanHY
 * @time 2019/6/14
 * @describe
 */
public class PreferenceUtil {

    private static final String PREFERENCE_SYSTEM = "USER_CASE_PREFERENCE_SYSTEM";

    //-------------------   custom by fhy    -----------------------------

    public static void putString(Context context, String key, String value) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(PREFERENCE_SYSTEM, Context.MODE_PRIVATE);
            sp.edit().putString(key, value).commit();
        }
    }

    public static String getString(Context context, String key) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(PREFERENCE_SYSTEM, Context.MODE_PRIVATE);
            return sp.getString(key, "");
        }
        return "";
    }

    public static void putInt(Context context, String key, int value) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(PREFERENCE_SYSTEM, Context.MODE_PRIVATE);
            sp.edit().putInt(key, value).commit();
        }
    }

    public static int getInt(Context context, String key, int value) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(PREFERENCE_SYSTEM, Context.MODE_PRIVATE);
            return sp.getInt(key, -1);
        }
        return -1;
    }
}
