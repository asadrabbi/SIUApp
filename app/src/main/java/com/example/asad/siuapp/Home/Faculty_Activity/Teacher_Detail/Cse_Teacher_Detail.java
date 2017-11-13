package com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.shobojit.siuapp.R;
import com.google.gson.Gson;
import com.roger.catloadinglibrary.CatLoadingView;

import org.json.JSONObject;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Cse_Teacher_Detail extends AppCompatActivity {
    Toolbar tl ;
    TeacherJson teacherJson;
    CatLoadingView mView;
    SharedPreferences preferences;
    Context cn;
    ListView csefaclist;
    // private String link="https://firebasestorage.googleapis.com/v0/b/siuapp-ea105.appspot.com/o/teacher_detail.txt?alt=media&token=885e0155-b4b8-4ec3-a87a-66fae1bb15ad";
    private String link = "http://javaloverbd.000webhostapp.com/teacher_detail.txt";
    private RequestQueue req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse__teacher__detail);
        cn = this;
        mView = new CatLoadingView();
        mView.show(getSupportFragmentManager(),"Loading.........");
        Toolbar();
        csefaclist = (ListView) findViewById(R.id.csefaclist);
        req = Volley.newRequestQueue(this);
        preferences = getSharedPreferences("JsonData",cn.MODE_PRIVATE);
        if(!haveNetworkConnection()){
            String res = preferences.getString("csefaculty","null");
            if(!res.equals("null")) {
                Gson gson = new Gson();
                teacherJson = gson.fromJson(res, TeacherJson.class);
                csefaclist.setAdapter(new TList(cn, teacherJson.getCse()));
                if(mView!=null){
                    mView.dismiss();
                }
            }else {
                Snackbar.make(findViewById(R.id.csefactol),"No Internet Connection",Snackbar.LENGTH_LONG)
                        .show();
            }
        }else{
            netWork();
        }

    }

    void netWork(){
        JsonObjectRequest jsr = new JsonObjectRequest(Request.Method.GET, link, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String result = response.toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("csefaculty",result);
                editor.commit();
                Gson gson = new Gson();
                teacherJson = gson.fromJson(result,TeacherJson.class);
                csefaclist.setAdapter(new TList(cn, teacherJson.getCse()));
                if(mView!=null){
                    mView.dismiss();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        req.add(jsr);

    }



    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }


    void Toolbar (){
        tl= (Toolbar) findViewById(R.id.csefactol);
        setSupportActionBar(tl);
        getSupportActionBar().setTitle("Faculty Members");
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

    class TList extends BaseAdapter {
        private Context cn;
        List<TeacherJson.CseBean> cse;
        public TList(Context cn, List<TeacherJson.CseBean> cse) {
            this.cn = cn;
            this.cse=cse;
        }
        @Override
        public int getCount() {
            return cse.size();
        }
        @Override
        public Object getItem(int position) {
            return cse.get(position);
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) cn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(convertView==null){
                convertView = inflater.inflate(R.layout.custom_faculty_members,parent,false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.tname);
            TextView designation = (TextView) convertView.findViewById(R.id.tdesignation);
            TextView phone = (TextView) convertView.findViewById(R.id.tphone);
            CircleImageView cr = (CircleImageView) convertView.findViewById(R.id.timg);
            TeacherJson.CseBean c = cse.get(position);
            Glide.with(cn).load(c.getImage()).placeholder(R.drawable.male).dontAnimate().into(cr);

            name.setText(c.getName());
            designation.setText(c.getDesignation());
            phone.setText("Phone: "+c.getMob());


            return convertView;
        }
    }
}
