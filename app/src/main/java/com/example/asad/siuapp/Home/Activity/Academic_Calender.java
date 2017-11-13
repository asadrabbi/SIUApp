package com.example.asad.siuapp.Home.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import com.aapbd.appbajarlib.notification.BusyDialog;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;

public class Academic_Calender extends AppCompatActivity {
    WebView wv;
    String url="http://siu.edu.bd/academic-calendar/";
    private Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic__calender);
        wv= (WebView) findViewById(R.id.acwebview);
        cn=this;
        if(!isNetworkAvailable()) {
            Snackbar.make(findViewById(R.id.acwebview), "No Internet Connection", Snackbar.LENGTH_LONG).show();
        }
        startWebView(url);

    }
    //WebView wv;
    private void startWebView(String url) {
        wv.setWebViewClient(new WebViewClient() {
            /*ProgressDialog progressDialog;*/
            // BusyDialog bd;
            CatLoadingView mView;
            boolean dailogLoading =false;
            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
              /*  if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(cn);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();

                }*/
                if(dailogLoading==false) {
                    /*if (bd == null) {*/
                        if(mView==null){

                        mView = new CatLoadingView();
                        mView.show(getSupportFragmentManager(),"Loading.........");

                        // in standard case YourActivity.this
                      /*  bd = new BusyDialog(cn, true, "Loading.....");
                        bd.show();*/
                        dailogLoading=true;
                    }
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                 /*   if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }*/

                    if(mView!=null){
                        mView.dismiss();
                    }

               /*    bd.dismis();
                    bd=null;*/
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        wv.getSettings().setJavaScriptEnabled(true);

        // Other webview options

	    wv.getSettings().setLoadWithOverviewMode(true);
	    wv.getSettings().setUseWideViewPort(true);
	    wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	    wv.setScrollbarFadingEnabled(false);
	    wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setAppCacheMaxSize( 5 * 1024 * 1024 );
        wv.getSettings().setAppCachePath( cn.getCacheDir().getAbsolutePath() );
        wv.getSettings().setAllowFileAccess( true );
        wv.getSettings().setAppCacheEnabled( true );
        wv.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT );


        // loading offline
        if (!isNetworkAvailable() ) {
            wv.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }
        //Load url in webview
        wv.loadUrl(url);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // Open previous opened link from history on webview when back button pressed
    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(wv.canGoBack()) {
            wv.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }

    }
}
