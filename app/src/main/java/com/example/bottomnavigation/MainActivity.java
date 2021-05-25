package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeMainActivity();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        HomeFragment homeFragment=new HomeFragment();
        ProfileFragment profileFragment=new ProfileFragment();
        SearchFragment searchFragment=new SearchFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.parentFrameLayout,homeFragment);
        fragmentTransaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_Home:

                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.parentFrameLayout,homeFragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.nav_Profile:
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();

                        fragmentTransaction1.replace(R.id.parentFrameLayout,profileFragment);
                        fragmentTransaction1.commit();
                        break;
                    case R.id.nav_Search:
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.parentFrameLayout,searchFragment);
                        fragmentTransaction2.commit();
                        break;
                }
                return true;


            }
        });

    }


    void InitializeMainActivity(){
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

    }
}