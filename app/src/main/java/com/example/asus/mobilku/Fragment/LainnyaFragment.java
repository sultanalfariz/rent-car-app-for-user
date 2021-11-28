package com.example.asus.mobilku.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.asus.mobilku.LoginActivity;
import com.example.asus.mobilku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LainnyaFragment extends Fragment {

    RelativeLayout btnLogout;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    public LainnyaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lainnya, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.btn_logout);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class );
                SharedPreferences.Editor data = sharedPreferencesId.edit();
                data.clear();
                data.commit();
                getActivity().startActivity(intent);
            }
        });
    }
}
