package com.example.asad.siuapp.Home.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class Chairman extends AppCompatActivity {
    SimpleDraweeView ChairmanImage;
    String ChairText;
    WebView Chairwv;
    Toolbar tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chairman_fragment);
        ChairmanInit();
        tl = (Toolbar) findViewById(R.id.chtool);
        tl.setTitle("Chairman");
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

    public void ChairmanInit(){
        ChairText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman1) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman2) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman3) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman4) +"</font>"+"</p> "
                + "</body></html>";

        Chairwv = (WebView) findViewById(R.id.chairmanText);
        Chairwv.loadData(ChairText, "text/html", "utf-8");

        //Image
        ChairmanImage= (SimpleDraweeView) findViewById(R.id.chairmanimage);
        String ChairmanImagepath="res:/" + R.drawable.chairman;
        //ChairmanImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/chairman-sir1-1023x450.jpg"));
        ChairmanImage.setImageURI(Uri.parse(ChairmanImagepath));
    }
}
