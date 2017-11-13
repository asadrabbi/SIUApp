package com.example.asad.siuapp.Home.Faculty_Activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail.Cse_Teacher_Detail;
import com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail.Ece_Teacher_Detail;
import com.example.asad.siuapp.Home.Syllabus_Activity.Cse_syl;
import com.example.asad.siuapp.Home.Syllabus_Activity.Ece_syl;
import com.example.asad.siuapp.Home.lab.cse_lab;
import com.example.asad.siuapp.Home.lab.ece_lab;
import com.example.shobojit.siuapp.R;

public class Eng_fac extends AppCompatActivity {
    Toolbar tl;
    Button csesyl,csisyl,ecesyl,cselab,csilab,ecelab,csefac,csifac,ecefac;
    private Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_fac);
        cn=this;
        Initialization();

        //For Syl
        csesyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new  Csesyl().execute();}
        });
        csisyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new Csesyl().execute();}});
        ecesyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new ECEsyl().execute();}});

        //For lab
       cselab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       new Runnable(){
                    @Override
                    public void run() {startActivity(new Intent(cn,cse_lab.class).putExtra("Toolbar","CSE Lab"));}
                }.run();}
        });
       csilab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        new Runnable(){
                    @Override
                    public void run() {startActivity(new Intent(cn,cse_lab.class).putExtra("Toolbar","CSI Lab"));}
                }.run();}
        });
        ecelab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(cn,ece_lab.class));
            }
        });


       //Faculty Members
      csefac.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {startActivity(new Intent(cn, Cse_Teacher_Detail.class));}
        });
      csifac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(cn, Cse_Teacher_Detail.class));}
        });
      ecefac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(cn, Ece_Teacher_Detail.class));}});

    }


    void Initialization(){
        tl= (Toolbar) findViewById(R.id.engtol);
        setSupportActionBar(tl);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        csefac = (Button) findViewById(R.id.csefac);
        csifac = (Button) findViewById(R.id.csifac);
        ecefac = (Button) findViewById(R.id.ecefac);

        csesyl= (Button) findViewById(R.id.csesyl);
        csisyl= (Button) findViewById(R.id.csisyl);
        ecesyl= (Button) findViewById(R.id.ecesyl);

        cselab= (Button) findViewById(R.id.cselab);
        csilab= (Button) findViewById(R.id.csilab);
        ecelab= (Button) findViewById(R.id.ecelab);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    public class Csesyl extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            startActivity(new Intent(cn,Cse_syl.class));
            return null;
        }
    }
    public class ECEsyl extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            startActivity(new Intent(cn,Ece_syl.class));
            return null;
        }
    }
}



