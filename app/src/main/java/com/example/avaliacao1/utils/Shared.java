package com.example.avaliacao1.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Shared {

    private static Context activity;

    public Shared (Context activity) {
        this.activity = activity;
    }

    public static final void put(final String key, final Object value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();

        if(value instanceof String){
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else {
            Toast.makeText(activity, "Tipo de dado inválido!", Toast.LENGTH_LONG).show();
        }

        editor.apply();
    }

    public static final String getString(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getString(key, "");
    }
    public static final boolean getBoolean(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean(key, false);
    }
}
