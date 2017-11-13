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


public class Chairman  extends Fragment {
    View v;
    SimpleDraweeView ChairmanImage;
    String ChairText;
    WebView Chairwv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.chairman_fragment,container,false);
        ChairmanInit(v);
        return v;
    }


    public void ChairmanInit(View v){
        ChairText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman1) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman2) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman3) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman4) +"</font>"+"</p> "
                + "</body></html>";

        Chairwv = (WebView) v.findViewById(R.id.chairmanText);
        Chairwv.loadData(ChairText, "text/html", "utf-8");

        //Image
        ChairmanImage= (SimpleDraweeView) v.findViewById(R.id.chairmanimage);
        String ChairmanImagepath="res:/" + R.drawable.chairman;
        //ChairmanImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/chairman-sir1-1023x450.jpg"));
        ChairmanImage.setImageURI(Uri.parse(ChairmanImagepath));
    }
}
