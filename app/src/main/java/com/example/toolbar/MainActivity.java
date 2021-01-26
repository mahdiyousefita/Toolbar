package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager();
    }

    private void fragmentManager() {
        getSupportFragmentManager().beginTransaction().replace(R.id.activityMainFrameLayout, ScrollFragment.newInstance()).commit();
    }
}