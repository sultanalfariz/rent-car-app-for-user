package com.example.asus.mobilku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.mobilku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PencarianFragment extends Fragment {


    public PencarianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pencarian, container, false);
    }

}
