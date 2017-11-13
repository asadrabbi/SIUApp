package com.example.asad.siuapp.Home.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Notice_Detail_02 extends AppCompatActivity {
    public String url;
    ImageView noticeImage;
    Toolbar tl;
    CatLoadingView mView;
    PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice__detail_02);
        noticeImage= (ImageView) findViewById(R.id.noticeImage);
        tl = (Toolbar) findViewById(R.id.noticedetailimage);
        tl.setTitle("Notice Image");
        setSupportActionBar(tl);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent in = getIntent();
        Bundle b = in.getExtras();
        url=b.getString("link");


        new AsyncTask<Object, Object, String>(){
            @Override
            protected void onPreExecute() {
                mView = new CatLoadingView();
                mView.show(getSupportFragmentManager(),"Loading.........");
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Object... params) {
                Document doc = null;
                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements link = doc.select(".notice_image img[src~=(?i)\\.(png|jpe?g|gif)]");
                String imgurl = link.attr("src");
                return imgurl;
            }

            @Override
            protected void onPostExecute(String s) {
                ImageLoading(s);
                super.onPostExecute(s);
            }
        }.execute();

    }

    public void ImageLoading(String url){

        Glide.with(this).load(url).listener(new RequestListener<String, GlideDrawable>() {
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
        }).into(noticeImage);
        mAttacher = new PhotoViewAttacher(noticeImage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
