package com.example.dagger3;

import android.os.Bundle;

import dagger.android.support.DaggerAppCompatActivity;
import jakarta.inject.Inject;

public class HomeActivity extends DaggerAppCompatActivity {

    @Inject
    HomeFragment mHomeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_home, mHomeFragment)
                .commit();
    }

}