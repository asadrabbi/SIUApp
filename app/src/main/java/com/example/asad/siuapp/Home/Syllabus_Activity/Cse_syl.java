package com.example.asad.siuapp.Home.Syllabus_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.shobojit.siuapp.R;

public class Cse_syl extends AppCompatActivity {
    Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_syl);
        Intialization();
    }

    void Intialization(){
        tl= (Toolbar) findViewById(R.id.csesyltool);
        setSupportActionBar(tl);
        getSupportActionBar().setTitle("Syllabus");
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
}
