package com.example.hcd_fresher048.androidsettingsdemo2;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SettingsActivity extends PreferenceActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);
        FrameLayout frame = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.frame_contain_settings_fragment, root, false);

        root.addView(bar, 0); // insert at top
        root.addView(frame, 1);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_contain_settings_fragment, new SettingsFragment())
                .commit();

    }
}
