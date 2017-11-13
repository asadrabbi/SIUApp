package com.example.asad.siuapp.Home.FragmentContainer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by SHOBOJIT on 12/18/2016.
 */

public class Facilites extends Fragment {
    View v;
    SimpleDraweeView hos,campus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.facilites_fragment,container,false);
        hos= (SimpleDraweeView) v.findViewById(R.id.hostel);
        hos.setImageURI(Uri.parse("res:/"+R.drawable.hostel));

     /*   campus= (SimpleDraweeView) v.findViewById(R.id.campus);
        campus.setImageURI(Uri.parse("res:/"+R.drawable.campus));*/
        return v;
    }
}
