package com.example.kaan.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class Alloperation extends AppCompatActivity {

    private Button mevcutbilgibtn;
    private TextView etxt;
    private ConstraintLayout constraintLayout,constraintLayout2;
    private ScrollView scrollView2;
    public void init() {
        mevcutbilgibtn = findViewById(R.id.mevcutbilgibtn);


        constraintLayout = new ConstraintLayout(this);
        constraintLayout = findViewById(R.id.constraintLayout);


        constraintLayout2 = new ConstraintLayout(this);
        constraintLayout2 = findViewById(R.id.constraintlayout2);

        scrollView2 = new ScrollView(this);



    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alloperation);
        init();
        int  i = 1;
        ConstraintSet set = new ConstraintSet();
        etxt = new EditText(this);
        etxt.setId(i);
        etxt.setHint(". Ders İsmi");
        etxt.setTextSize(20);


      //  etxt.setId(i);
        constraintLayout2.addView(etxt,0);
        set.clone(constraintLayout2);
        set.connect(etxt.getId(), ConstraintSet.TOP,constraintLayout2.getId(), ConstraintSet.TOP, 0);
        set.applyTo(constraintLayout2);

    }
}
