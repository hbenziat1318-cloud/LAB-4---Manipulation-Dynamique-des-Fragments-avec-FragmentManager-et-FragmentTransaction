package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btnFragment1);
        Button btn2 = findViewById(R.id.btnFragment2);

        // Afficher le premier fragment au démarrage
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne());
        }

        btn1.setOnClickListener(v -> replaceFragment(new FragmentOne()));
        btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}