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

    public void handleChangeFragment(View view){
        Fragment selectedFragment;
        if(view == findViewById(R.id.btnhome)) {
            selectedFragment = new Home();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }
        else if(view == findViewById((R.id.btnPackages))){
            selectedFragment = new Package();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }
//        else if(view == findViewById(R.id.btnBookings)){
//            selectedFragment = new Booking();
//            fragmentManager = getFragmentManager();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.bookings_fragment_container, selectedFragment);
//            fragmentTransaction.commit();
//        }
//        else if(view == findViewById(R.id.btnCustomers)){
//            selectedFragment = new Customer();
//            fragmentManager = getFragmentManager();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.customer_fragment_container, selectedFragment);
//            fragmentTransaction.commit();
//        }

    }
}
