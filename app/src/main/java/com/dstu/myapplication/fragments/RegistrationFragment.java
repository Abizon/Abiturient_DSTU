package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dstu.myapplication.R;

public class RegistrationFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.registr, container, false);
        getActivity().setTitle("Регистрация");
        Button button2 = (Button)view.findViewById(R.id.button2);
        Button button3 = (Button)view.findViewById(R.id.button3);
        Button button4 = (Button)view.findViewById(R.id.button4);
        Button button5 = (Button)view.findViewById(R.id.button5);
        Button button6 = (Button)view.findViewById(R.id.button6);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment()).commit();
                break;
            case R.id.button3:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment2()).commit();
                break;
            case R.id.button4:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment3()).commit();
                break;
            case R.id.button5:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment4()).commit();
                break;
            case R.id.button6:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegistrationFragment2()).commit();
                break;
        }
    }
}
