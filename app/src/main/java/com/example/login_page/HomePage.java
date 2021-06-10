package com.example.login_page;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    BlankFragment blankFragment;
    settings_frag setfrag;
    TextView frame_name;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        frame_name = findViewById(R.id.content_name);

        actionBarDrawerToggle = new ActionBarDrawerToggle(HomePage.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);
        blankFragment = new BlankFragment();
        setfrag = new settings_frag();
        fragmentManager = getSupportFragmentManager();
        addfragment(blankFragment);

    }

    public void draweropen(View view) {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            drawerLayout.openDrawer(navigationView);
        }
    }

    public void setsettings(View view) {
        addfragment(setfrag);
        setlabel("Settings", frame_name);

    }

    public void dashboard(View view) {
        addfragment(blankFragment);
        setlabel("Dashboard", frame_name);
    }

    public void addfragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(navigationView);
    }

    void setlabel(String string, TextView view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setText(string);
            }
        });
    }
}