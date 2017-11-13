package com.example.asad.siuapp.Home.FragmentContainer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shobojit.siuapp.R;

/**
 * Created by SHOBOJIT on 12/15/2016.
 */

public class Contact extends Fragment {
    View v;
    CardView phone,fax,mobile,email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.contact_fragment, container,false);
        phone= (CardView) v.findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:821717193")));
            }
        });
        fax= (CardView) v.findViewById(R.id.fax);
        mobile= (CardView) v.findViewById(R.id.mobile);
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01754313182")));
            }
        });
        email= (CardView) v.findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto: info@siu.edu.bd"));
                startActivity(Intent.createChooser(emailIntent, ""));
            }
        });

        return v;
    }
}
