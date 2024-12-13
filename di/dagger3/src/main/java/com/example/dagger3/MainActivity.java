package com.example.dagger3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dagger3.data.CarRepository;
import com.example.dagger3.di.HomeActivityComponent;

import jakarta.inject.Inject;

public class MainActivity extends AppCompatActivity {
    HomeActivityComponent mComponent;

    @Inject
    Fragment mHomeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComponent = ((CarApp) (getApplication())).appComponent()
                .homeActivityComponent().build();
        mComponent.inject(this);

        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_home, mHomeFragment)
                .commit();
    }

    public HomeActivityComponent getComponent() {
        return mComponent;
    }
}