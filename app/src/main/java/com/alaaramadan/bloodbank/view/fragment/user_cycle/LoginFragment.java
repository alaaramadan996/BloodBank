package com.alaaramadan.bloodbank.view.fragment.user_cycle;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaramadan.bloodbank.R;
import com.alaaramadan.bloodbank.data.api.ApiService;
import com.alaaramadan.bloodbank.data.local.SharedPreferencesManger;
import com.alaaramadan.bloodbank.data.models.Login.Login;
import com.alaaramadan.bloodbank.databinding.FragmentLoginBinding;
import com.alaaramadan.bloodbank.utils.InternetState;
import com.alaaramadan.bloodbank.view.activities.HomeActivity;
import com.alaaramadan.bloodbank.view.base.BaseFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.alaaramadan.bloodbank.data.api.RetrofitClient.getClient;
import static com.alaaramadan.bloodbank.data.local.SharedPreferencesManger.USER_DATA;
import static com.alaaramadan.bloodbank.data.local.SharedPreferencesManger.saveData;
import static com.alaaramadan.bloodbank.utils.HelperMethod.disappearKeypad;
import static com.alaaramadan.bloodbank.utils.HelperMethod.dismissProgressDialog;
import static com.alaaramadan.bloodbank.utils.HelperMethod.onCreateErrorToast;
import static com.alaaramadan.bloodbank.utils.HelperMethod.onCreateSuccessToast;
import static com.alaaramadan.bloodbank.utils.HelperMethod.replaceFragment;
import static com.alaaramadan.bloodbank.utils.HelperMethod.showProgressDialog;
import static com.alaaramadan.bloodbank.utils.HelperMethod.showValidation;


public class LoginFragment extends BaseFragment {
   private FragmentLoginBinding binding;
   private ApiService apiService;
   private SharedPreferencesManger sharedPreferencesManger;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate( inflater,R.layout.fragment_login,container,false );

        apiService = getClient().create( ApiService.class );
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        setOnClick( binding.loginFragmentBtnLogin );
        setOnClick( binding.loginFragmentCheckBoxRemember );
        setOnClick( binding.loginFragmentTvForgetPassword );
    }

    @Override
    public void onClickItem(View view) {
        disappearKeypad(getActivity(),view);
        synchronized (view){
            switch (view.getId()){
                case R.id.login_fragment_btn_login:
                    startLogin();
                    break;
                case R.id.login_fragment_check_box_remember:
                    break;
                case R.id.login_fragment_tv_forget_password:
                    replaceFragment( getFragmentManager(),R.id.auth_activity_frame_layout_container,new ForgetPasswordFragment() );
                    break;
                    
             
            }
        }
        super.onClickItem( view );
    }

    private void startLogin() {
        String phone = binding.loginFragmentEtNamberPhone.getText().toString();
        String password = binding.loginFragmentEtPassword.getText().toString();

        if (phone.isEmpty()) {
            showValidation(binding.loginFragmentTvErrorPhone, "ادخل اسم المستخدم", true);
            return;
        } else {
            showValidation(binding.loginFragmentTvErrorPhone, "", false);
        }

        if (password.isEmpty()) {
            showValidation(binding.loginFragmentTvErrorPassword, "ادخل كلمة المرور", true);
            return;
        } else {
            showValidation(binding.loginFragmentTvErrorPassword, "", false);
        }
        if (InternetState.isConnected(getActivity())) {
            showProgressDialog(getActivity(), getString(R.string.please_wait));

            apiService.setDataLogin(phone, password).enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    dismissProgressDialog();
                    if (response.body().getStatus()==1) {
                        onCreateSuccessToast(getActivity(), response.body().getMsg());
                        saveData(baseActivity, USER_DATA, response.body().getData());
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                        getActivity().finish();

                    } else {
                        onCreateErrorToast(getActivity(), response.body().getMsg());

                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    onCreateErrorToast(getActivity(), getString(R.string.error));
                    dismissProgressDialog();

                }
            });

        } else {
            try {
                onCreateErrorToast(getActivity(), getString(R.string.no_internet_connection));
                dismissProgressDialog();

            } catch (Exception e) {

            }
        }



    }
}
