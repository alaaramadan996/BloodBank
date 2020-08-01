package com.alaaramadan.bloodbank.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.view.base.BaseActivity;
import com.alaaramadan.bloodbank.view.fragment.splash.SliderThreeFragment;
import com.alaaramadan.bloodbank.view.fragment.user_cycle.LoginFragment;

import static com.alaaramadan.bloodbank.utils.HelperMethod.changeLang;
import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;

public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeLang(this, "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        replaceFragment( getSupportFragmentManager(),R.id.auth_activity_frame_layout_container,new LoginFragment() );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
