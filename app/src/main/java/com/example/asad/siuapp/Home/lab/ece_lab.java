package com.example.asad.siuapp.Home.lab;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

public class ece_lab extends AppCompatActivity {
    private String em = "https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fece%2Fem.jpg?alt=media&token=ef68f59d-a1ca-49e9-b27b-c4dcd3a4fa01";
    private String em2 ="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fece%2Fem2.jpg?alt=media&token=eba6bed4-5cda-4f16-be98-9f6dd861f3b0";
    private String ec="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fece%2Fec.jpg?alt=media&token=264b0320-8e2d-4676-a9cd-f1b3c6e08f59";
    private String ec2="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fece%2Fec2.jpg?alt=media&token=9c58e8f2-c8c2-403b-b0a8-c794478f678e";
    private String ee="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fece%2Fee.jpg?alt=media&token=4032e2d6-354f-40f2-a395-42e76d4b4765";

    SimpleDraweeView emlab, em2lab, eclab, ec2lab, eelab;
    Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_lab);
        Initialization();
        FrescoImageLoading();
    }

    void  FrescoImageLoading(){
        emlab.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        emlab.setImageURI(Uri.parse(em));
        em2lab.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        em2lab.setImageURI(Uri.parse(em2));
        eclab.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        eclab.setImageURI(Uri.parse(ec));
        ec2lab.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        ec2lab.setImageURI(Uri.parse(ec2));
        eelab.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        eelab.setImageURI(Uri.parse(ee));

    }


    void Initialization() {
        tl = (Toolbar) findViewById(R.id.ecelabtol);
        setSupportActionBar(tl);
        getSupportActionBar().setTitle("ECE Lab");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        emlab= (SimpleDraweeView)findViewById(R.id.emlab);
        em2lab= (SimpleDraweeView)findViewById(R.id.emlab2);
        eclab= (SimpleDraweeView)findViewById(R.id.eclab);
        ec2lab= (SimpleDraweeView)findViewById(R.id.ec2lab);
        eelab= (SimpleDraweeView)findViewById(R.id.eelab);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}