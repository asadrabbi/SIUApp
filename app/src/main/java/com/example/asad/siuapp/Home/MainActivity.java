package com.example.asad.siuapp.Home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

//import com.aapbd.appbajarlib.nagivation.StartActivity;
//import com.aapbd.appbajarlib.notification.AlertMessage;
import com.example.asad.siuapp.Home.Activity.Academic_Calender;
import com.example.asad.siuapp.Home.FragmentContainer.Authority;
import com.example.asad.siuapp.Home.FragmentContainer.Chairman;
import com.example.asad.siuapp.Home.FragmentContainer.Facilites;
import com.example.asad.siuapp.Home.Activity.Notice_Activity;
import com.example.asad.siuapp.Home.FragmentContainer.Admission;
import com.example.asad.siuapp.Home.FragmentContainer.American_corner;
import com.example.asad.siuapp.Home.FragmentContainer.Contact;
import com.example.asad.siuapp.Home.FragmentContainer.Home;
import com.example.asad.siuapp.Home.FragmentContainer.Library;
import com.example.asad.siuapp.Home.FragmentContainer.School_Fragment;
import com.example.shobojit.siuapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private NavigationView nav;
    private FrameLayout frame;
    private Handler hand ;
    private static int FragIndex=0;
    private  static int toolbartitle=0;
    private static boolean Flag=false;
    private Toolbar toolbar;
    private Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con=this;
        InitializeUi();
        Toolbar();
        hand =new Handler();
        LoadHomeFragment();

        if(haveNetworkConnection()==false){
            //AlertMessage.showMessage(con,"Alert","No Internet Connection","OK",R.drawable.alertpic);
            Snackbar.make(findViewById(R.id.toolbar),"No Internet Connection",Snackbar.LENGTH_LONG)
                    .show();
        }
    }



    public void InitializeUi(){
        dl= (DrawerLayout) findViewById(R.id.dl);
        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        frame = (FrameLayout) findViewById(R.id.frame);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void Toolbar(){
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        dl.setDrawerListener(toggle);

        toggle.syncState();
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


    public void LoadHomeFragment(){
        FragIndex=1;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("Home");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Home(),"Home Fragment")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }

    }


    public void LoadChairman(){
        FragIndex=3;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("Chairman");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Chairman(),"Chairman Fragment")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }

    }

    public void LoadAuth(){
        FragIndex=2;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("Authority");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Authority(),"Authority Fragment")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }

    }


    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
            if(FragIndex==1){
                AlertDialog alertDialog = new AlertDialog.Builder(con).create();
                alertDialog.setTitle("Alert");
                alertDialog.setIcon(R.drawable.alertpic);
                alertDialog.setMessage("Are you sure you want to exit?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }else{
                LoadHomeFragment();
            }
        }




    public void LoadAdmission(){
        FragIndex=3;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("Admission");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Admission(),"Admission Fragment")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }
    }


    public void LoadCorner(){
        FragIndex=10;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("American Corner");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new American_corner(),"American Corner")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }
    }


    public void loadSchool(){
        FragIndex=4;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new School_Fragment())
                        .addToBackStack("School Fragment")
                        .commit();
                getSupportActionBar().setTitle("School");
            }
        };
        if(runnable!=null){
            hand.post(runnable);
        }
    }

    public void loadLibrary(){
        FragIndex=7;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Library())
                        .addToBackStack("Library Fragment")
                        .commit();
                getSupportActionBar().setTitle("SIU Library");
            }
        };
        if(runnable!=null){
            hand.post(runnable);
        }
    }


    public void loadFacilites(){
        FragIndex=11;
        Runnable run =new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Facilites())
                        .addToBackStack("Facilites Fragment")
                        .commit();
                getSupportActionBar().setTitle("Facilites");
            }
        };

        if(run!=null){
            hand.post(run);
        }
    }

    public void LoadContact(){
        FragIndex =12;
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        getSupportActionBar().setTitle("Contact");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,new Contact(),"Contact")
                        .commit();
            }
        };

        if(runnable!=null){
            hand.post(runnable);
        }
    }

    public void ExitMethod(){
        AlertDialog alertDialog = new AlertDialog.Builder(con).create();
        alertDialog.setTitle("Alert");
        alertDialog.setIcon(R.drawable.alertpic);
        alertDialog.onWindowFocusChanged(true);
        alertDialog.setMessage("Are you sure you want to exit?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(1);
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }


    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int menuitem =item.getItemId();

        if(menuitem==R.id.home){
            if(FragIndex!=1)
                LoadHomeFragment();
        }
        else if(menuitem==R.id.authomenu){
            if(FragIndex!=2)
                LoadAuth();
        }
     /*   else if(menuitem==R.id.chairmanmenu){
            if(FragIndex!=3)
                LoadChairman();
        }*/

        else if(menuitem==R.id.admission){
            if(FragIndex!=3)
                LoadAdmission();
        }
        else if(menuitem==R.id.library){
            if(FragIndex!=7)
                loadLibrary();
        }

        else if(menuitem==R.id.website){
            if(haveNetworkConnection()==false)
                Snackbar.make(findViewById(R.id.toolbar),"No Internet Connection",Snackbar.LENGTH_LONG)
                        .show();
           // AlertMessage.showMessage(con,R.drawable.alertpic,"Alert","No Internet Connection");
            else
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://siu.edu.bd/")));
        }

        else if(menuitem==R.id.school) {
            if(FragIndex!=4)
            loadSchool();
        }

        else if(menuitem==R.id.facilities)
        {   if(FragIndex!=11)
            loadFacilites();
        }

        else if(menuitem==R.id.calender) {
           /* if(haveNetworkConnection()==false)

               //AlertMessage.showMessage(con,R.drawable.alertpic,"Alert","No Internet Connection");
            else*/
            //   StartActivity.toActivity(MainActivity.this, Academic_Calender.class);
            startActivity(new Intent(MainActivity.this, Academic_Calender.class));
        }

        else if(menuitem==R.id.notice){
            if(haveNetworkConnection()==false)
              Snackbar.make(findViewById(R.id.toolbar),"No Internet Connection",Snackbar.LENGTH_LONG).show();
                //AlertMessage.showMessage(con,R.drawable.alertpic,"Alert","No Internet Connection");
            else
            startActivity(new Intent(MainActivity.this,Notice_Activity.class));
        }

        else if(menuitem==R.id.americancorner) {
            if(FragIndex !=10)
            LoadCorner();
        }

        else if(menuitem==R.id.contact) {
            if(FragIndex !=12)
             LoadContact();
        }

        else if(menuitem==R.id.exit) {
            ExitMethod();
         }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}
