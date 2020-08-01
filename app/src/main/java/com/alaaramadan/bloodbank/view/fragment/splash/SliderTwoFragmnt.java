package com.alaaramadan.bloodbank.view.fragment.splash;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.databinding.SliderTwoFragmentBinding;
import com.alaaramadan.bloodbank.view.base.BaseFragment;

import static com.alaaramadan.bloodbank.utils.HelperMethod.disappearKeypad;
import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;


public class SliderTwoFragmnt extends BaseFragment {

    private SliderTwoFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate( inflater,R.layout.slider_two_fragment,container,false );
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        setOnClick( binding.sliderTwoFragmentBtnThrow );
    }

    @Override
    public void onClickItem(final View view) {
        disappearKeypad(getActivity(),view);
        synchronized (view){
            view.setEnabled( false );
            switch (view.getId()){
                case R.id.slider_two_fragment_btn_throw:
                    replaceFragment( getFragmentManager(),R.id.splash_activity_fragment_continar,new SliderThreeFragment() );
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


/*
    @Override
    public void onClickItem(final View view) {
        disappearKeypad(getActivity(), view);
        synchronized (view) {
            view.setEnabled(false);
            switch (view.getId()) {
                case R.id.login_fragment_tv_forget_password:
                    replaceFragment(getFragmentManager(), R.id.auth_activity_frame_container, new ForgetPasswordFragment());
                    break;
                case R.id.login_fragment_btn_login:
                    startLogin();
                    break;
                case R.id.login_fragment_lin_have_no_account:
                    replaceFragment(getFragmentManager(), R.id.auth_activity_frame_container, new RegisterFragment());
                    break;
                case R.id.login_fragment_btn_mail:
                    break;
                case R.id.login_fragment_btn_facebook:
                    break;
                case R.id.login_fragment_lin_sub_view:
                    break;
            }

            new Handler().postDelayed( new Runnable() {

                @Override
                public void run() {
                    view.setEnabled(true);
                }
            }, 2000);
        }
    }
*/

}