package com.example.asad.siuapp.OneSignalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageActivity extends AppCompatActivity {
    CatLoadingView mView;
    PhotoViewAttacher mAttacher;
    Toolbar tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        tl = (Toolbar) findViewById(R.id.notification);
        tl.setTitle(" Notification");
        String value = getIntent().getExtras().getString("img");
        ImageView img = (ImageView) findViewById(R.id.im);
        mView = new CatLoadingView();
        mView.show(getSupportFragmentManager(),"Loading.........");
        Glide.with(this).load(value).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                if(mView!=null){
                    mView.dismiss();
                }
                return false;
            }
        }).into(img);
       mAttacher = new PhotoViewAttacher(img);
    }
}
