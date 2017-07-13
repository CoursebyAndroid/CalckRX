package com.leshchenko.root.calcrx;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Root on 22.06.2017.
 */

public class PrefsAdapter
{
    private SharedPreferences mSharedPreferences;
    private Context mContext;
    private static final String BASE_NAME = "CalcRX.db";


    public PrefsAdapter(Context context) {
        super();
        this.mContext = context;
    }


    //insert
    public void insert(CalcResult calc) {
        mSharedPreferences = mContext.getSharedPreferences(BASE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(calc);
        prefsEditor.putString(BASE_NAME, json);
        prefsEditor.commit();
    }

    //READ
    public CalcResult read() {
        Gson gson = new Gson();
        mSharedPreferences = mContext.getSharedPreferences(BASE_NAME,
                Context.MODE_PRIVATE);
        String json = mSharedPreferences.getString(BASE_NAME, "");
        CalcResult calcResult = gson.fromJson(json, CalcResult.class);
        return calcResult;
    }

    //DELETE
    public void delete() {
        mSharedPreferences = mContext.getSharedPreferences(BASE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = mSharedPreferences.edit();
        sharedPreferencesEditor.remove(BASE_NAME);
        sharedPreferencesEditor.commit();
    }
}
