package com.example.asad.siuapp.Home.FragmentContainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shobojit.siuapp.R;

/**
 * Created by SHOBOJIT on 12/14/2016.
 */

public class Admission extends Fragment {
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.admission_fragment,container,false);
        return v;
    }
}
