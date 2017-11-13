package com.example.asad.siuapp.Home.Faculty_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail.Llb_Teacher_Detail;
import com.example.shobojit.siuapp.R;

public class Law_fac extends AppCompatActivity {
Toolbar tl;
    Button lawfac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_fac);
        Initialization();
        lawfac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Llb_Teacher_Detail.class));
            }
        });
    }

    void Initialization(){
        lawfac= (Button) findViewById(R.id.lawfac);
        tl= (Toolbar) findViewById(R.id.lawtol);
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
}
