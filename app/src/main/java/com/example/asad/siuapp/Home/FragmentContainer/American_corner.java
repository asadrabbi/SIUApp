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
 * Created by SHOBOJIT on 12/16/2016.
 */

public class American_corner extends Fragment {
    View v;
    SimpleDraweeView ac,ac2,ac3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.american_fragment,container,false);
        ac= (SimpleDraweeView) v.findViewById(R.id.american);
        String ACImagepath="res:/" + R.drawable.american1;
        ac.setImageURI(Uri.parse(ACImagepath));

        ac2= (SimpleDraweeView) v.findViewById(R.id.american1);
        ac2.setImageURI(Uri.parse("res:/"+R.drawable.american2));

        ac3= (SimpleDraweeView) v.findViewById(R.id.american2);
        ac3.setImageURI(Uri.parse("res:/"+R.drawable.american3));

        return v;
    }
}
