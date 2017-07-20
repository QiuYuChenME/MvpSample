package com.hl.baselib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.*;

public class BaseLibActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_lib);
    }
}
