package com.mathemagicians.hus;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioGroup;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        radioGroup = (RadioGroup) findViewById(R.id.language);
        radioGroup.check(R.id.radio_english);
    }

    public void next(View v) {
        int id = radioGroup.getCheckedRadioButtonId();

        if (id == R.id.radio_english) {
            setLocale("en");
        } else {
            setLocale("hi");
        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, CategoryActivity.class);
        startActivity(refresh);
        finish();
    }
}
