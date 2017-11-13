package com.example.asad.siuapp.Home.FragmentContainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asad.siuapp.Home.Activity.*;
import com.example.shobojit.siuapp.R;


/**
 * Created by SHOBOJIT on 2/25/2017.
 */

public class Authority  extends Fragment {
    View v;

    Button auth1,auth2,auth3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.authority, container, false);

        auth1 = (Button) v.findViewById(R.id.auth1);
        auth2 = (Button) v.findViewById(R.id.auth2);



        auth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), com.example.asad.siuapp.Home.Activity.Chairman.class));
            }
        });

        auth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Vc.class));
            }
        });



        return v;
    }
}
