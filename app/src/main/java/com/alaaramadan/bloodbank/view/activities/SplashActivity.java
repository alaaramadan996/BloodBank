package com.alaaramadan.bloodbank.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.databinding.ActivitySplashBinding;
import com.alaaramadan.bloodbank.utils.HelperMethod;
import com.alaaramadan.bloodbank.view.base.BaseActivity;
import com.alaaramadan.bloodbank.view.fragment.splash.StartSplashFragment;

import static com.alaaramadan.bloodbank.utils.HelperMethod.changeLang;
import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;

public class SplashActivity extends BaseActivity {
    private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeLang(this, "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        replaceFragment(getSupportFragmentManager(),R.id.splash_activity_fragment_continar,new StartSplashFragment() );



}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
