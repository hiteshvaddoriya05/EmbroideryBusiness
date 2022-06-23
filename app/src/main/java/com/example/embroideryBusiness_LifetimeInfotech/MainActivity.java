package com.example.embroideryBusiness_LifetimeInfotech;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.embroideryBusiness_LifetimeInfotech.Fragment.Home;
import com.example.embroideryBusiness_LifetimeInfotech.Fragment.MyApply;
import com.example.embroideryBusiness_LifetimeInfotech.Fragment.Orders;
import com.example.embroideryBusiness_LifetimeInfotech.Fragment.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView botamNavigationbar_main;


    String[] permission = {"android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.CAMERA",
            "android.permission.INTERNET",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    //===========================================================================================//

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestPermissions(permission, 200);


        botamNavigationbar_main = findViewById(R.id.botamNavigationbar_main);

        botamNavigationbar_main.setOnNavigationItemSelectedListener(listener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home()).commit();


    }//end oncrete--==============================================================================

    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menu_home:
                    fragment = new Home();
                    break;
                case R.id.menu_myApplys:
                    fragment = new MyApply();
                    break;
                case R.id.menu_myOrders:
                    fragment = new Orders();
                    break;
                case R.id.menu_Profiles:
                    fragment = new Profile();
                    break;

            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();


            return true;
        }
    };//------------end-----------

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(MainActivity.this, READ_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(MainActivity.this, CAMERA);
        int result2 = ContextCompat.checkSelfPermission(MainActivity.this, INTERNET);
        int result3 = ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED && result3 == PackageManager.PERMISSION_GRANTED;


    }//------------end-----------

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case 200:
                boolean readExternalStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean cameraAccess = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                boolean internet = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                boolean WRITE_EXTERNAL_STORAGE = grantResults[3] == PackageManager.PERMISSION_GRANTED;
                break;
        }
    }//------------end-----------



}//end class-==================================================================================