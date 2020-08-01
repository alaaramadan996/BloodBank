package com.alaaramadan.bloodbank.view.fragment.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.databinding.FragmentStartSplashBinding;
import com.alaaramadan.bloodbank.view.base.BaseFragment;

import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;


public class StartSplashFragment extends BaseFragment {
    private FragmentStartSplashBinding binding;
    private Handler handler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_start_splash, container, false);
        new  Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                replaceFragment( getFragmentManager(),R.id.splash_activity_fragment_continar,new SliderOneFragment() );

            }
        },1000);
       // replaceFragment( getFragmentManager(),R.id.splash_activity_fragment_continar,new SliderFragment() );

        return binding.getRoot();
    }
}
