package com.example.asad.siuapp.Home.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import com.aapbd.appbajarlib.notification.BusyDialog;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;

public class NoticeDetail extends AppCompatActivity {
    WebView wv;
    private Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);
        cn=this;
        Intent in = getIntent();
        Bundle b = in.getExtras();
        String url=b.getString("link");
        wv= (WebView) findViewById(R.id.wv);
        startWebView(url);
    }
    //WebView wv;
    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        wv.setWebViewClient(new WebViewClient() {
            /*ProgressDialog progressDialog;*/
            //BusyDialog bd;
            CatLoadingView mView;
            boolean dailogLoading =false;
            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onLoadResource (WebView view, String url) {
                if(dailogLoading==false) {
                    /*if (bd == null) {*/
                    if(mView==null){
                        mView = new CatLoadingView();
                        mView.show(getSupportFragmentManager(),"Loading.........");
                        dailogLoading=true;
                    }
                }
            }


            public void onPageFinished(WebView view, String url) {
                try{

                    if(mView!=null){
                        mView.dismiss();
                    }


                   /* bd.dismis();
                    bd=null;*/
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });


        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wv.setScrollbarFadingEnabled(false);
        wv.getSettings().setBuiltInZoomControls(true);


        wv.loadUrl(url);


    }

    @Override

    public void onBackPressed() {
        if(wv.canGoBack()) {
            wv.goBack();
        } else {
            super.onBackPressed();
        }

    }
}
