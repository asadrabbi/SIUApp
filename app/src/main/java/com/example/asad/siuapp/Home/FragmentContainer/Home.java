package com.example.asad.siuapp.Home.FragmentContainer;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.shobojit.siuapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.mancj.slideup.SlideUp;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Home extends Fragment  implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    TextView ttday,ttdate,ttmonth,tttime;
    private SliderLayout mDemoSlider;
    String HomeText , ChairText, VcText;
    private SlideUp slideUp;
    private View dim;
    private View slideView;
    public PieChart pieChart;
    WebView wv1,wv2,wv3;

    FloatingActionButton fab,fab_man,fab_exit;
    Animation fab_open,fab_clos,fab_rotate,fab_rotate_back;

    private float[] yData = {25.6f, 27.15f, 20.12f, 28.25f};
    private String[] xData = {"School of Engineering : 25.6%", "School of Laws :27.15%", "School of Humanities : 20.12%" , "School of Business : 28.25%"};

    View v;
    boolean isOpen =false;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.home_fragment,container,false);

        Text ();
        TextViewIntailization(v);
        Graph(v);
        ClockInit(v);
        SliderIntailization(v);
        FloatingIntialization(v);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                fab_man.startAnimation(fab_clos);
                    fab_exit.startAnimation(fab_clos);
                        fab.startAnimation(fab_rotate_back);
                    fab_exit.setVisibility(View.GONE);
                    fab_man.setVisibility(View.GONE);
                    fab_man.setClickable(false);
                    fab_exit.setClickable(false);
                    isOpen=false;
                }
                else {
                    fab_man.startAnimation(fab_open);
                    fab_exit.startAnimation(fab_open);
                    fab.startAnimation(fab_rotate);
                    fab_man.setClickable(true);
                    fab_exit.setClickable(true);
                    isOpen=true; }
            } });

        slideView = v.findViewById(R.id.slideView);
        slideUp = new SlideUp(slideView);
        slideUp.hideImmediately();

        fab_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideUp.animateIn();
                fab_man.startAnimation(fab_clos);
                fab_exit.startAnimation(fab_clos);
                fab.startAnimation(fab_rotate_back);
                fab_exit.setVisibility(View.GONE);
                fab_man.setVisibility(View.GONE);
                fab_man.setClickable(false);
                fab_exit.setClickable(false);
                isOpen=false;
                fab.hide();
            }
        });
        slideUp.setSlideListener(new SlideUp.SlideListener() {
            @Override
            public void onSlideDown(float v) {}
            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE)
                {
                    fab.show();

                }
            }
        });

        fab_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
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
        });
        return v;
    }


    public void Graph (View v){
        pieChart = (PieChart) v.findViewById(R.id.chart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Statistic");
        pieChart.setCenterTextSize(10);


       pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                String res =e.toString();
                //Entry, x: 0.0 y: 40.15 red
                //Entry, x: 0.0 y: 45.6 blue
                //Entry, x: 0.0 y: 56.55 yello
                //Entry, x: 0.0 y: 30.12 green
                int i= 0;
                if(res.equalsIgnoreCase("Entry, x: 0.0 y: 25.6")){
                    i=0;
                }else if(res.equalsIgnoreCase("Entry, x: 0.0 y: 27.15")){
                    i=1;
                }else if(res.equalsIgnoreCase("Entry, x: 0.0 y: 20.12")){
                    i=2;
                }else {
                    i=3;
                }
                Log.i("value",e.toString());
                Toast.makeText(getActivity(),xData[i],Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(),  e + " : "+ h , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        addDataSet();

}

    private void addDataSet() {

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , i));
        }

        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Student Statistic");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);
        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        pieDataSet.setColors(colors);
        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    public void FloatingIntialization(View v){
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab_man = (FloatingActionButton) v.findViewById(R.id.fab_man);
        fab_exit = (FloatingActionButton) v.findViewById(R.id.fab_exit);

        //For Animation
        fab_open = AnimationUtils.loadAnimation(getContext(),R.anim.fab_open);
        fab_clos = AnimationUtils.loadAnimation(getContext(),R.anim.fab_close);
        fab_rotate = AnimationUtils.loadAnimation(getContext(),R.anim.fab_rotat);
        fab_rotate_back= AnimationUtils.loadAnimation(getContext(),R.anim.fab_rotate_back);
    }



    public void Text (){
        HomeText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.Home1) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.Home2) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.Home3) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.Home4) +"</font>"+ "</p> "
                + "</body></html>";
    }



    public void ClockInit(View v){
        ttday= (TextView) v.findViewById(R.id.ttday);
        ttdate= (TextView) v.findViewById(R.id.ttdate);
        ttmonth= (TextView) v.findViewById(R.id.ttmonth);

        String []day = {"Sunday","Monday","Tuesday","Wednesday","Wednesday","Friday","Saturday"};
        Calendar c = Calendar.getInstance();
        ttday.setText(day[c.getTime().getDay()]);
        SimpleDateFormat df = new SimpleDateFormat("dd");
        ttdate.setText(df.format(c.getTime()));
        SimpleDateFormat d2 = new SimpleDateFormat("MMMMMM");
        ttmonth.setText( d2.format(c.getTime()));

    }


    public void TextViewIntailization(View v){
        wv1 = (WebView) v.findViewById(R.id.NormalText);
        wv1.loadData(HomeText, "text/html", "utf-8");

    }




    public void SliderIntailization(View v){
        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("SIU Garden", R.drawable.siu_garden);
        file_maps.put("SIU Main Gate",R.drawable.s2);
        file_maps.put("Physics Olympiad ",R.drawable.physics2);
        file_maps.put("Sylhet International University",R.drawable.campus);
        file_maps.put("Ambassador Bernicat at SIU",R.drawable.usa);
        file_maps.put("2nd Convocation of SIU ",R.drawable.ca);
        file_maps.put("Physics Olympiad at Siu ",R.drawable.physics1);
        file_maps.put("SIU Campus", R.drawable.s5);
         for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }





    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
