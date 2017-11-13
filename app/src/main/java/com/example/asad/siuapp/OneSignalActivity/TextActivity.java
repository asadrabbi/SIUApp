package com.example.asad.siuapp.OneSignalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shobojit.siuapp.R;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        String value = getIntent().getExtras().getString("info");
        TextView tt1 = (TextView) findViewById(R.id.t);
        tt1.setText(value);
    }
}
