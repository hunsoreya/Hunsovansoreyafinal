package com.example.hunsovansoreya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeActivity()).commit();
    }
     private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             Fragment selectedFragment=null;
             switch (item.getItemId()){

                 case R.id.home:
                     selectedFragment= new HomeActivity();
                     break;
                 case R.id.categories:
                     selectedFragment= new CategoriesActivity();
                     break;
                 case R.id.search:
                     selectedFragment= new SearchActivity();
                     break;
                 case R.id.account:
                     selectedFragment= new AccountActivity();
                     break;
             }
             getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();
             return true;
         }
     };

}