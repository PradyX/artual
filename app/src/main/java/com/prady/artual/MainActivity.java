package com.prady.artual;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;
import com.prady.artual.fragments.HomeFragment;
import com.prady.artual.fragments.SearchFragment;
import com.prady.artual.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.coordinator_main);
        bottomAppBar = findViewById(R.id.bottom_bar);
        setSupportActionBar(bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "Menu", Snackbar.LENGTH_LONG).show();
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_search:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.down_to_up, R.anim.slide_out_left, R.anim.up_to_down, R.anim.slide_out_to_right)
                        .replace(R.id.container, new SearchFragment()).addToBackStack(null).commit();
                break;
            case R.id.bottom_settings:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.down_to_up, R.anim.slide_out_left, R.anim.up_to_down, R.anim.slide_out_to_right)
                        .replace(R.id.container, new SettingsFragment()).addToBackStack(null).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
