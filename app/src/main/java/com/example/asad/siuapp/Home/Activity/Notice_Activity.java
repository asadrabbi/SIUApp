package com.example.asad.siuapp.Home.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//import com.aapbd.appbajarlib.notification.BusyDialog;
import com.example.asad.siuapp.Home.model.ArrayAdap;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Notice_Activity extends AppCompatActivity {
    ListView lv;
    Toolbar tl;

    private Context cn;
    ArrayList<String> link = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        cn=this;
        Initailizaion();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              /*  Intent in = new Intent(cn,NoticeDetail.class);
                in.putExtra("link",link.get(position));
                startActivity(in);*/


                Intent in = new Intent(cn,Notice_Detail_02.class);
                in.putExtra("link",link.get(position));
                startActivity(in);
            }
        });

        new FetchNotice().execute();
    }

    public void Initailizaion(){
        tl = (Toolbar) findViewById(R.id.noticebar);
        tl.setTitle(" Notice");
        setSupportActionBar(tl);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        lv= (ListView) findViewById(R.id.lv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public class FetchNotice extends AsyncTask<Void, Void, Void> {
        ProgressDialog pd;
        CatLoadingView mView;
       // BusyDialog busyDialog;
        String url = "http://siu.edu.bd/category/notice/";
        ArrayList<String> datetime= new ArrayList<String>();
        ArrayList<String>notice = new ArrayList<String>();

        @Override
        protected void onPreExecute() {
          /*  super.onPreExecute();*/
         /*   busyDialog = new BusyDialog(cn,true,"Loading....");
            busyDialog.show();*/
           mView = new CatLoadingView();
          mView.show(getSupportFragmentManager(),"Loading.........");
/*
            whorlView = (WhorlView) findViewById(R.id.whorl);
            whorlView.animate();
            whorlView.isCircling();
            whorlView.start();*/
        }

        @Override

        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements date = doc.select(".single_notice .noticeboard_date");
                Elements noticename = doc.select(".single_notice .notice_title");
                Elements address = doc.select(".single_notice .notice_title a");


                for(Element t : date){
                    datetime.add(t.text());
                }

                for(Element t : noticename){
                    notice.add(t.text());
                }
                //For Notice Address
                for(Element t : address){
                    link.add(t.attr("href"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
         /*   if (busyDialog != null)
            {
                busyDialog.dismis();
            }*/
            if(mView!=null){
                mView.dismiss();
            }
            /*whorlView.stop();
            whorlView.setVisibility(View.GONE);*/
            ArrayAdap a = new ArrayAdap(Notice_Activity.this,datetime,notice);
            lv.setAdapter(a);

        }
    }
}
