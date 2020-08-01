package com.alaaramadan.bloodbank.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alaaramadan.bloodbank.R;

import static com.alaaramadan.bloodbank.utils.HelperMethod.changeLang;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeLang(this, "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}
