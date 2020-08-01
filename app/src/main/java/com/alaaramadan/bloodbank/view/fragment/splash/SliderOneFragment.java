package com.alaaramadan.bloodbank.view.fragment.splash;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.databinding.SliderOneFragmentBinding;
import com.alaaramadan.bloodbank.view.base.BaseFragment;

import static com.alaaramadan.bloodbank.utils.HelperMethod.disappearKeypad;
import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;

public class SliderOneFragment extends BaseFragment {

    private SliderOneFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,R.layout.slider_one_fragment,container,false
        );
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        setOnClick( binding.sliderOneFragmentBtnThrow );
    }

    @Override
    public void onClickItem(final View view) {
        disappearKeypad(getActivity(),view);
        synchronized (view){
            view.setEnabled( false );
            switch (view.getId()){
                case R.id.slider_one_fragment_btn_throw:
                    replaceFragment( getFragmentManager(),R.id.splash_activity_fragment_continar,new SliderTwoFragmnt() );
                    break;
            }
            new Handler(  ).postDelayed( new Runnable() {
                @Override
                public void run() {
                    view.setEnabled( true );

                }
            },1000 );
        }
        super.onClickItem( view );
    }
}