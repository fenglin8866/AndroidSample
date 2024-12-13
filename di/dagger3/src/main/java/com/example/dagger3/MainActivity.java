package com.example.dagger3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dagger3.data.CarRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Fragment fragment=new MainFragment(new HomePresenter(CarRepository.getInstance()));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_home, fragment)
                .commit();
    }
}