package com.example.asad.siuapp.Home.FragmentContainer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by SHOBOJIT on 12/27/2016.
 */

public class Chancellor extends Fragment {
    View v;
    SimpleDraweeView VCImage;
    WebView vcweb;
    String VcText;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.vc_fragment,container,false);
        VcInit(v);
        return v;
    }

    public void VcInit(View v){
        //For text
        VcText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc1) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc2) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.vc3) +"</font>"+ "</p> "
                + "</body></html>";

        vcweb = (WebView) v.findViewById(R.id.vctext);
        vcweb.loadData(VcText, "text/html", "utf-8");


        //For Image
        VCImage= (SimpleDraweeView) v.findViewById(R.id.vcimage);
        String VCImagepath="res:/" + R.drawable.vc;
        //VCImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/vc.jpg"));
        VCImage.setImageURI(Uri.parse(VCImagepath));
    }
}
