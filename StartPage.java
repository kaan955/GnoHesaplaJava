package com.example.kaan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;

public class StartPage extends AppCompatActivity {

    private Button btn;
    private TextView txt,uyarı,uyarı2,uyarı3;
    private EditText etxt,güncelkredi,güncelgno;
    private RadioButton x,y,z,w;
    private RadioGroup groupradio;

    public static int a = 1;
    public static double güncelkredisayı = 0.0;
    public static double güncelgnosayı = 0.0;
    public static int  radiogroupnum = 0;

    public void init()
    {
        btn = new Button (this);
        txt = new TextView(this);
        etxt = new EditText(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        init();

        txt = findViewById(R.id.textView);
        etxt = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        güncelkredi = findViewById(R.id.güncelkredi);
        güncelgno = findViewById(R.id.güncelgno);
        uyarı = findViewById(R.id.uyarı);
        uyarı2= findViewById(R.id.notsistemitxt);
        uyarı3 = findViewById(R.id.uyarı3);
        x = findViewById(R.id.aaradio);
        y = findViewById(R.id.aradio);
        z = findViewById(R.id.a1radio);
        groupradio = findViewById(R.id.radiogroup);

        w = new RadioButton(this);

        btn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {


                        String result = etxt.getText().toString();
                        if(result.equals(""))
                        {
                            a = 0;
                        }
                        else {
                            a = Integer.parseInt(result);
                        }

                        String skredi = güncelkredi.getText().toString();

                        if(skredi.equals(""))
                        {
                            güncelkredisayı = 0;
                        }
                        else{
                            güncelkredisayı = Double.parseDouble(skredi);
                        }



                        String sgno = güncelgno.getText().toString();
                        if(sgno.equals(""))
                        {
                            güncelgnosayı = 0;
                        }
                        else{
                            güncelgnosayı = Double.parseDouble(sgno);
                        }





                        if (groupradio.getCheckedRadioButtonId() != -1)
                        {
                            int rnum = groupradio.getCheckedRadioButtonId();

                            w = findViewById(rnum);

                            String radiotext = w.getText().toString();

                            if(radiotext.equals("AA"))
                            {
                                radiogroupnum = 1;
                            }
                            else if ((radiotext.equals("A (A+)")))
                            {
                                radiogroupnum = 2;
                            }
                            else if ((radiotext.equals("A1")))
                            {
                                radiogroupnum = 3;
                            }
                            else{
                                radiogroupnum = 0;
                            }
                        }
                        else
                        {
                           radiogroupnum = 0 ;
                        }





                            if((güncelgnosayı >4.01) || (güncelkredisayı > 500))
                        {
                            uyarı3.setText("GNO: 0.0 - 4.0 \n Kredi: 500'ü aşamaz!");
                            uyarı3.setVisibility(View.VISIBLE);
                        }
                        else {
                                uyarı3.setVisibility(View.INVISIBLE);

                                if (a > 0 && a < 51 && radiogroupnum > 0) {
                                    Intent secondpage = new Intent(StartPage.this, Mytry.class);
                                    startActivity(secondpage);
                                    uyarı.setVisibility(View.INVISIBLE);
                                    uyarı2.setVisibility(View.INVISIBLE);

                                } else if ((a <= 0 || a > 51) && radiogroupnum < 1) {
                                    uyarı.setText("DERS SAYISI: 1-50 Arasıda Değer Giriniz ! ");
                                    uyarı.setVisibility(View.VISIBLE);
                                    uyarı2.setText("Sistemi Seçiniz !");
                                    uyarı2.setVisibility(View.VISIBLE);
                                } else if (a <= 0 || a > 51) {
                                    uyarı.setText("DERS SAYISI: 1-50 Arasıda Değer Giriniz ! ");
                                    uyarı.setVisibility(View.VISIBLE);
                                    uyarı2.setVisibility(View.GONE);
                                } else if (radiogroupnum < 1) {
                                    uyarı2.setText("Sistemi Seçiniz !");
                                    uyarı2.setVisibility(View.VISIBLE);
                                    uyarı.setVisibility(View.GONE);

                                } else {
                                    uyarı.setText("DERS SAYISI: 1-50 Arasıda Değer Giriniz ! ");
                                    uyarı.setVisibility(View.VISIBLE);
                                    uyarı2.setText("Sistemi Seçiniz !");
                                    uyarı2.setVisibility(View.VISIBLE);
                                }

                            }



                    }
                });



    }



}
