package com.example.asad.siuapp.Home.FragmentContainer;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.shobojit.siuapp.R;


/**
 * Created by SHOBOJIT on 1/6/2017.
 */

public class Library  extends Fragment {
    View v;
    private String LibText;
    WebView lib;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.library_fragment,container,false);
        LibraryTXT(v);
        return v;
    }
   public void LibraryTXT(View v){
       LibText = "<html><body>"
               + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.library) +"</font>"+"</p> "
               + "</body></html>";

       lib = (WebView) v.findViewById(R.id.librarytxt);
       lib.loadData(LibText, "text/html", "utf-8");

   }

}