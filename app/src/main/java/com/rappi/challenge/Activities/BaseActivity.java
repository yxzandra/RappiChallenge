package com.rappi.challenge.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.rappi.challenge.API.response.PrincipalResponse;
import com.rappi.challenge.API.retrofit.RetrofitMagnament;
import com.rappi.challenge.Interface.OnResponseInterface;
import com.rappi.challenge.R;

import butterknife.ButterKnife;

/**
 * Created by yxzan on 14/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    abstract public int getLayout();
    abstract public void onCreateView(Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        if (isTablet(this)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        onCreateView(savedInstanceState);
    }

    public void newActivity(Activity activity) {
        Intent intent = new Intent(this,activity.getClass());
        startActivity(intent);
        finish();
    }

    public void putFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();



    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void initAnimation(ImageView imageMostach) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotation_animate);
        imageMostach.startAnimation(animation);
    }

}
