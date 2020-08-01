package com.alaaramadan.bloodbank.view.fragment.splash;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.databinding.FragmentSliderBinding;
import com.alaaramadan.bloodbank.view.base.BaseFragment;


public class SliderFragment extends BaseFragment {

    private FragmentSliderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(
                inflater,R.layout.fragment_slider,container,false
        );
        return binding.getRoot();
    }
}
