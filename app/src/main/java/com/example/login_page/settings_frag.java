package com.example.login_page;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class settings_frag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings_frag, container, false);
        LinearLayout view_branch=view.findViewById(R.id.branch);
        LinearLayout financial=view.findViewById(R.id.financial);
        financial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_activity(Branch_settings.class);
            }
        });
        view_branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_activity(Branch_settings.class);
            }
        });
        return view;
    }
    void change_activity(Class classname){
        Intent intent=new Intent(getContext(),classname);
        startActivity(intent);
    }
}