package com.example.asad.siuapp.Home.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class Vc extends AppCompatActivity {
    SimpleDraweeView VCImage;
    WebView vcweb;
    String VcText;
    Toolbar tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vc_fragment);
        VcInit();
        tl = (Toolbar) findViewById(R.id.vctool);
        tl.setTitle("Vice Chancellor ");
        setSupportActionBar(tl);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public void VcInit(){
        //For text
        VcText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc1) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc2) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.vc3) +"</font>"+ "</p> "
                + "</body></html>";

        vcweb = (WebView)findViewById(R.id.vctext);
        vcweb.loadData(VcText, "text/html", "utf-8");


        //For Image
        VCImage= (SimpleDraweeView)findViewById(R.id.vcimage);
        String VCImagepath="res:/" + R.drawable.vc;
        //VCImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/vc.jpg"));
        VCImage.setImageURI(Uri.parse(VCImagepath));
    }
}


