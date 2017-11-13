package com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.shobojit.siuapp.R;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

public class engdbating extends AppCompatActivity {
    SimpleDraweeView lng1,lng2,lng3,lng4,lng5;
    Toolbar tl;
    String l2= "https://firebasestorage.googleapis.com/v0/b/fir-storage-cdd2c.appspot.com/o/English%20Language%20Culb%2F16143671_750046528484339_6575456865554576454_o.jpg?alt=media&token=2804423b-1750-4986-a577-ebdfb5aec28b";
    String l1="https://firebasestorage.googleapis.com/v0/b/fir-storage-cdd2c.appspot.com/o/English%20Language%20Culb%2F16251608_754171574738501_4007532079555196724_o.jpg?alt=media&token=419286fa-6465-48c5-b158-f90941fb0406";
    String l3 = "https://firebasestorage.googleapis.com/v0/b/fir-storage-cdd2c.appspot.com/o/English%20Language%20Culb%2F16487843_758089571013368_8832913539372821353_o.jpg?alt=media&token=e6fdebdf-421c-443c-a434-bc1d2e78e07c";
    String l4 = "https://firebasestorage.googleapis.com/v0/b/fir-storage-cdd2c.appspot.com/o/English%20Language%20Culb%2F16601747_10206167184939036_7375591514411930947_o.jpg?alt=media&token=44d9ddc7-0939-4321-bfe2-8b25a81f3c43";
    String l5 = "https://firebasestorage.googleapis.com/v0/b/fir-storage-cdd2c.appspot.com/o/English%20Language%20Culb%2F16177747_750047118484280_5656551580791355950_o.jpg?alt=media&token=77a61a27-bc4f-42a5-9855-15605e1e9e7d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engdbating);
        Initialization();
        FrescoImageLoading();
    }



    void  FrescoImageLoading(){
        lng1.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        lng1.setImageURI(Uri.parse(l1));
        lng2.setImageURI(Uri.parse(l2));
        lng3.setImageURI(Uri.parse(l3));
        lng4.setImageURI(Uri.parse(l4));
        lng5.setImageURI(Uri.parse(l5));
    }


    void Initialization(){
        tl= (Toolbar) findViewById(R.id.engdbatool);
        setSupportActionBar(tl);
        getSupportActionBar().setTitle("English Language Club");
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        lng1= (SimpleDraweeView)findViewById(R.id.lng1);
        lng2= (SimpleDraweeView)findViewById(R.id.lng2);
        lng3= (SimpleDraweeView)findViewById(R.id.lng3);
        lng4= (SimpleDraweeView)findViewById(R.id.lng4);
        lng5= (SimpleDraweeView)findViewById(R.id.lng5);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
