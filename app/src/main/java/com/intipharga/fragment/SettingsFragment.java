package com.intipharga.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

import com.intipharga.activity.R;

/**
 * Created by macair on 2/10/16.
 */
public class SettingsFragment extends PreferenceFragment {

    private AppCompatActivity activity;

    public SettingsFragment(){}

    public static SettingsFragment newInstance(AppCompatActivity activity){
        SettingsFragment fragment = new SettingsFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_general);
    }
}
