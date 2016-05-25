package com.mileapps.androidanimations.common;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mileapps.androidanimations.R;

/**
 * Created by ErickSteven on 24/05/2016.
 */
public class Utilities {

    public static void makeToolbar(AppCompatActivity activity, boolean homeAsUpEnabled, String title) {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar).findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
        activity.getSupportActionBar().setTitle(title);
    }
}
