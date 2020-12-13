package com.example.fragmentinteraction;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fragmentinteraction.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private SharedViewModel viewModel;
    FragmentABinding binding;

    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();

    public MutableLiveData<String> passLive = new MutableLiveData<>();
    public MutableLiveData<String> emailLive = new MutableLiveData<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false);
        View view = binding.getRoot();

        binding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setText(binding.editText.getText());
            }
        });

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                password.setValue(passLive.getValue());
                email.setValue(emailLive.getValue());

                System.out.println("!!!!!!!!!!!" + password + "  " + email);

                Toast.makeText(view.getContext(), password.toString() + " and " + email.toString(), Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {

            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                binding.editText.setText(charSequence);
            }
        });
    }

    //    @BindingAdapter("android:text")
//    public static void setText(TextView view, int value) {
//        view.setText(Integer.toString(value));
//    }

}