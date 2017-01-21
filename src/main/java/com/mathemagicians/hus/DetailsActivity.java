package com.mathemagicians.hus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mathemagicians.hus.employee.FormFragment;
import com.mathemagicians.hus.employee.ProblemFragment;
import com.mathemagicians.hus.employee.SchemesFragment;
import com.mathemagicians.hus.employee.StatsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabClickListener;

import java.io.File;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    int category = 0;

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        category = getIntent().getIntExtra("category", 1);

        bottomBar = (BottomBar) findViewById(R.id.bottombar);
        setUpBottomBar();
    }

    public void setUpBottomBar() {
        bottomBar.noResizeGoodness();
        bottomBar.noTabletGoodness();
        bottomBar.noNavBarGoodness();
        bottomBar.setActiveTabColor("#EF9223");
        bottomBar.useFixedMode();

        bottomBar.setItems(
                new BottomBarTab(R.drawable.problem, R.string.problem),
                new BottomBarTab(R.drawable.ic_action_name, R.string.schemes),
                new BottomBarTab(R.drawable.ic_action_stats, R.string.stats),
                new BottomBarTab(R.drawable.ic_action_form, R.string.form)
        );

        final FragmentManager fragMan = getSupportFragmentManager();

        bottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                Fragment f = new com.mathemagicians.hus.employer.ProblemFragment();
                if(category == 0) {
                    switch(position) {
                        case 0:
                            f = new com.mathemagicians.hus.employer.ProblemFragment();
                            break;
                        case 1:
                            f = new com.mathemagicians.hus.employer.SchemesFragment();
                            break;
                        case 2:
                            f = new com.mathemagicians.hus.employer.StatsFragment();
                            break;
                        case 3:
                            f = new com.mathemagicians.hus.employer.FormFragment();
                            break;
                    }
                } else{
                    switch(position) {
                        case 0:
                            f = new ProblemFragment();
                            break;
                        case 1:
                            f = new SchemesFragment();
                            break;
                        case 2:
                            f = new StatsFragment();
                            break;
                        case 3:
                            f = new FormFragment();
                            break;
                    }
                }
                fragTxn.replace(R.id.container, f);
                fragTxn.commit();
            }

            @Override
            public void onTabReSelected(int position) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            try{
                ArrayList<Uri> uris = new ArrayList<Uri>();
                Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                sendIntent.setType("application/vnd.android.package-archive");
                uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
                sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(sendIntent, null));


            }catch(Exception e){

                ArrayList<Uri> uris = new ArrayList<Uri>();
                Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                sendIntent.setType("application/zip");
                uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
                sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(sendIntent, null));
            }
        } else if (id == R.id.action_about) {
            startActivity(new Intent(DetailsActivity.this,About.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
