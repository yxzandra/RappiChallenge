package com.rappi.challenge.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.rappi.challenge.R;

import butterknife.ButterKnife;

/**
 * Created by yxzan on 14/02/2017.
 */

public abstract class BaseFragment extends Fragment {
    abstract public int getLayout();
    abstract public void onViewReady();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        onViewReady();
        return view;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public void newActivity(Activity activity) {
        Intent intent = new Intent(getContext(),activity.getClass());
        startActivity(intent);
    }

    public void initAnimation(ImageView imageMostach) {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.rotation_animate);
        imageMostach.startAnimation(animation);
    }




}
