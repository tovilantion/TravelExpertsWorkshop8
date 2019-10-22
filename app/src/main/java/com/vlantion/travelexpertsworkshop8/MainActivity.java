package com.vlantion.travelexpertsworkshop8;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    On button click load fragment
    public void handleChangeFragment(View view){
        Fragment selectedFragment;
        if(view == findViewById(R.id.btnhome)) {
            selectedFragment = new HomeFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }
        else if(view == findViewById((R.id.btnPackages))){
            selectedFragment = new PackageActivity();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }
        else if(view == findViewById(R.id.btnBookings)){
            selectedFragment = new BookingFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }
        else if(view == findViewById(R.id.btnCustomers)){
            selectedFragment = new CustomerFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }

    }
}
