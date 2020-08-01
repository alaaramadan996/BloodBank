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
import com.alaaramadan.bloodbank.databinding.SliderThreeFragmentBinding;
import com.alaaramadan.bloodbank.view.activities.AuthActivity;
import com.alaaramadan.bloodbank.view.activities.HomeActivity;
import com.alaaramadan.bloodbank.view.base.BaseFragment;

import static com.alaaramadan.bloodbank.data.local.SharedPreferencesManger.loadUserData;
import static com.alaaramadan.bloodbank.utils.HelperMethod.disappearKeypad;

public class SliderThreeFragment extends BaseFragment {

    private SliderThreeFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate( inflater,R.layout.slider_three_fragment,container,false );
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        setOnClick( binding.sliderThreeFragmentBtnOk );
    }

    @Override
    public void onClickItem(View view) {
        disappearKeypad( getActivity(),view );
        synchronized (view){
            view.setEnabled( false );
            switch (view.getId())
            {
                case R.id.slider_three_fragment_btn_ok:
                    new Handler().postDelayed( new Runnable() {
                        @Override
                        public void run() {
                            if (loadUserData(getActivity()) == null) {
                                Intent intent = new Intent(getActivity(), AuthActivity.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(getActivity(), HomeActivity.class);
                                startActivity(intent);

                            }

                        }
                    }, 1000);
                    break;
            }
        }
        super.onClickItem( view );
    }
}