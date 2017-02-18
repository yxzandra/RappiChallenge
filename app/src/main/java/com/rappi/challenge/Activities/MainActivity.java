package com.rappi.challenge.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rappi.challenge.Fragment.PrincipalFragment;
import com.rappi.challenge.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerProduct)
    RecyclerView recyclerProduct;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        putFragment(new PrincipalFragment());
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_allCategories) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.instanceCategoryNull)));

        } else if (id == R.id.nav_utilities) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryUtilities)));

        } else if (id == R.id.nav_games) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryGames)));

        } else if (id == R.id.nav_photoAndvideos) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryPhotoAndVideo)));

        } else if (id == R.id.nav_socialNetworking) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategorySocialNetworking)));

        } else if (id == R.id.nav_navigation) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryNavigation)));

        }else if (id == R.id.nav_livestyle) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryLifestyle)));

        }else if (id == R.id.nav_Music) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryMusic)));

        }else if (id == R.id.nav_productivity) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryProductivity)));

        }else if (id == R.id.nav_entretaiment) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryEntretaiment)));

        }else if (id == R.id.nav_finance) {
            putFragment(PrincipalFragment.newInstance(getString(R.string.InstanceCategoryFinance)));

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
