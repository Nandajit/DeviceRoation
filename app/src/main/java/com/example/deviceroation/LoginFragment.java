package com.example.deviceroation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deviceroation.databinding.LoginLayoutBinding;

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LoginLayoutBinding binding = DataBindingUtil.inflate(inflater,R.layout.login_layout,container,false);
        View view = binding.getRoot();
        binding.setLoginVM(new LoginViewModel());
        return view;
    }
}
