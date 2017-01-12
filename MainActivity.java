package com.example.hcd_fresher048.androidsettingsdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";
    private Context mContext;
    private Button mButton;
    private TextView mTextView;

    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
//        mSharedPreferences.edit().clear().commit();
        Log.d(TAG, "onCreate: ");

        mButton = (Button) findViewById(R.id.btn);
        mTextView = (TextView) findViewById(R.id.tv);

        // Set a click listener for the text view
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AboutActivity.class);
                startActivity(intent);
            }
        });

        // Get the user's settings from SharedPreferences

    }



    @Override
    protected void onResume() {
        super.onResume();
        String userName = mSharedPreferences.getString(getString(R.string.sp_key_user_name),"Guest");
        String api = mSharedPreferences.getString(getString(R.string.sp_key_choice_api),"CNN");
        boolean showBoldText = mSharedPreferences.getBoolean(getString(R.string.sp_key_show_bold_text), false);
        boolean showRedTextColor = mSharedPreferences.getBoolean(getString(R.string.sp_key_show_red_text_color),false);

        // If user preferred to show bold txt then make it bold
        if(showBoldText){
            mTextView.setTypeface(null, Typeface.BOLD);
        }else {
            mTextView.setTypeface(null,Typeface.NORMAL);
        }

        // Update the text with SharedPreferences
        mTextView.setText("Hello " + userName + ", API: " + api);

        // Display red color text based on user settings
        if(showRedTextColor){
            mTextView.setTextColor(Color.RED);
        }else {
            mTextView.setTextColor(Color.BLACK);
        }
    }
}
