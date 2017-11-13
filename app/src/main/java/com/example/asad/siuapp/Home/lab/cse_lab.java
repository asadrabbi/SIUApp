package com.example.asad.siuapp.Home.lab;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

public class cse_lab extends AppCompatActivity {
    private String claburl ="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fclab.jpg?alt=media&token=c2da5bb5-fbe6-4024-891d-78949431c8d8" ;
    private String blaburl = "https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fblab.jpg?alt=media&token=1dccf0eb-86f9-42ef-a8f5-c5c91837e295" ;
    private String slaburl = "https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/Lab%2Fslab.jpg?alt=media&token=e19c2224-8b03-4094-9ec0-6d2875c63194";
    private String crtclaburl ;
    SimpleDraweeView cimg,bimg,simg,crtcimg;
    Toolbar tl;
    String toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_lab);
        toolbar= getIntent().getStringExtra("Toolbar");
        Initialization();
        FrescoImageLoading();
       // Intent intent = getIntent();

    }


    void  FrescoImageLoading(){
        cimg.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        cimg.setImageURI(Uri.parse(claburl));
        bimg.setImageURI(Uri.parse(blaburl));
        simg.setImageURI(Uri.parse(slaburl));
    }



    void Initialization(){
        tl= (Toolbar) findViewById(R.id.cselabtol);
        setSupportActionBar(tl);
        getSupportActionBar().setTitle(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        cimg= (SimpleDraweeView)findViewById(R.id.clab);
        bimg= (SimpleDraweeView)findViewById(R.id.blab);
        simg= (SimpleDraweeView)findViewById(R.id.slab);
        crtcimg= (SimpleDraweeView)findViewById(R.id.crtclab);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
