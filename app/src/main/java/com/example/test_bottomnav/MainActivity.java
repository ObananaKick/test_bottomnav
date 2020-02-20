package com.example.test_bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private FragmentMeasure fragmentMeasure = new FragmentMeasure();
    private FragmentResult fragmentResult = new FragmentResult();
    private FragmentTrend fragmentTrend = new FragmentTrend();
    private FragmentMore fragmentMore = new FragmentMore();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_main, fragmentMeasure).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.bottomNavigationMeasureMenuId: {
                        transaction.setCustomAnimations(R.animator.fade_entry, R.animator.rotate_exit).replace(R.id.frame_main, fragmentMeasure).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottomNavigationResultMenuId: {
                        transaction.setCustomAnimations(R.animator.rotate_entry, R.animator.rotate_exit).replace(R.id.frame_main, fragmentResult).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottomNavigationTrendMenuId: {
                        transaction.setCustomAnimations(R.animator.rotate_entry, R.animator.rotate_exit).replace(R.id.frame_main, fragmentTrend).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottomNavigationMoreMenuId: {
                        transaction.setCustomAnimations(R.animator.rotate_entry, R.animator.rotate_exit).replace(R.id.frame_main, fragmentMore).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });



    }
}
