package com.divisions.smslistener;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MAIN_ACTIVITY";
    public static TextView displayText;
    public static  FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        displayText = findViewById(R.id.textView);
        frameLayout = findViewById(R.id.displayFrame);

    }
}