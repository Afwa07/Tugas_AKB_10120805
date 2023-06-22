package com.example.rekomendasirestoran;

//10120805
//Muhammad Afwa F Muaja
//IF-2


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.rekomendasirestoran.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ProfileFragment());


        binding.bottomview.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.Info:
                    replaceFragment(new InfoFragment());
                    break;
                case R.id.Maps:s:
                    replaceFragment(new MapsFragment());
                    break;
                case R.id.Profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }

            return true;

        });



    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }


}