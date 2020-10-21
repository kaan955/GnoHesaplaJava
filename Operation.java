package com.example.kaan.myapplication;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.example.kaan.myapplication.StartPage.a;
import static com.example.kaan.myapplication.StartPage.radiogroupnum;

public class Operation extends AppCompatActivity {

    public static double GNO = 0.0;
    public static double KrediTotal = 0.0;
    public static double Puan = 0.0;


    private Button btn,createrbtn;
    private TextView txt,gnohesaplama;
    private EditText etxt;
    private LinearLayout linearl,linear2,linear3;
    private Spinner spinner,spinnera;

    private double harfcalculator(String harf) {

        double number=0;

       if(radiogroupnum == 2) {
           if (harf.equals("A") || harf.equals("A+")) {
               number = 4.00;
           } else if (harf.equals("A-")) {
               number = 3.70;

           } else if (harf.equals("B+")) {
               number = 3.30;

           } else if (harf.equals("B")) {
               number = 3.0;
           } else if (harf.equals("B-")) {
               number = 2.70;
           } else if (harf.equals("C+")) {
               number = 2.30;
           } else if (harf.equals("C")) {
               number = 2.00;

           } else if (harf.equals("C-")) {
               number = 1.70;

           } else if (harf.equals("D+")) {
               number = 1.30;
           } else if (harf.equals("D")) {
               number = 1.00;
           } else if (harf.equals("D-")) {
               number = 0.7;
           } else if (harf.equals("B+")) {
               number = 0.0;
           }
       }
       else if (radiogroupnum == 1) {
           if (harf.equals("AA")) {
               number = 4.0;
           } else if (harf.equals("BA")) {
               number = 3.5;
           } else if (harf.equals("BB")) {
               number = 3.0;
           } else if (harf.equals("CB")) {
               number = 2.5;
           } else if (harf.equals("CC")) {
               number = 2.0;
           } else if (harf.equals("DC")) {
               number = 1.5;
           } else if (harf.equals("DD")) {
               number = 1.0;
           } else if (harf.equals("FD")) {
               number = 0.5;
           } else if (harf.equals("FF")) {
               number = 0.0;
           }
       }
           else if(radiogroupnum == 3)
           {
               if(harf.equals("A1"))
               {
                   number = 4.0;
               }
               else if(harf.equals("A2"))
               {
                   number = 3.75;
               }
               else if(harf.equals("A3"))
               {
                   number = 3.5;
               }
               else if(harf.equals("B1"))
               {
                   number = 3.25 ;
               }
               else if(harf.equals("B2"))
               {
                   number = 3.0 ;
               }
               else if(harf.equals("B3"))
               {
                   number = 2.75 ;
               }else if(harf.equals("C1"))
               {
                   number = 2.5 ;
               }
               else if(harf.equals("C2"))
               {
                   number = 2.25;
               }
               else if(harf.equals("C3"))
               {
                   number = 2.0;
               }
               else if(harf.equals("D"))
               {
                   number = 1.75;
               }  else if(harf.equals("F"))
               {
                   number = 0;
               }



           }

        return number;
       }//Harften Puana Ceviriyorum






    public  void init()
    {
        btn = new Button (this);
        txt = new TextView(this);
        etxt = new EditText(this);

        linearl = new LinearLayout(this);
        linear2 = new LinearLayout(this);
        linear3 = new LinearLayout(this);

        linearl.setOrientation(LinearLayout.VERTICAL);
        linear2.setOrientation(LinearLayout.VERTICAL);
        linear3.setOrientation(LinearLayout.VERTICAL);

        etxt= findViewById(R.id.editText);
        gnohesaplama = findViewById(R.id.gnohesap);

        createrbtn = findViewById(R.id.createrbtn);
        linearl = findViewById(R.id.linearl);
        linear2 = findViewById(R.id.linearll);
        linear3 = findViewById(R.id.linearlll);




        for(int i = 1 ; i <= a*3; i++)
        {

            etxt = new EditText(this);
            etxt.setId(i);
            etxt.setHint(i + ". Ders İsmi");
            etxt.setTextSize(12);


            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(140,50);
            lp1.setMargins(0,0,0,0);
            etxt.setLayoutParams(lp1);
            linearl.addView(etxt);

            spinner = new Spinner(this);
            spinner.setId(i);
            ArrayAdapter adapters = ArrayAdapter.createFromResource(this,R.array.kredi,android.R.layout.simple_dropdown_item_1line );
            spinner.setAdapter(adapters);
            lp1.setMargins(0,0,0,0);
            spinner.setLayoutParams(lp1);
            linear2.addView(spinner);


            spinnera = new Spinner(this);
            spinnera.setId(i);
            if(radiogroupnum == 2) {
                ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.aplusharf, android.R.layout.simple_spinner_dropdown_item);
                spinnera.setAdapter(adapter2);}
            else if(radiogroupnum == 3)
            {  ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.a1harf, android.R.layout.simple_spinner_dropdown_item);
                spinnera.setAdapter(adapter2);}
            else if (radiogroupnum == 1) {
                ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.aaharf, android.R.layout.simple_spinner_dropdown_item);
                spinnera.setAdapter(adapter2);
            }
            lp1.setMargins(0,0,0,0);
            spinnera.setLayoutParams(lp1);
            linear3.addView(spinnera);

        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.operation);
        init();


        createrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value=0.0,harf=0.0;

                for (int j = 1; j <= a; j++) {
                    View element = linearl.getChildAt(j);
                    View element2 = linear2.getChildAt(j);
                    View element3 = linear3.getChildAt(j);




                    if (element2 instanceof Spinner) {
                        Spinner elementspinner = (Spinner)element2;
                        String text = elementspinner.getSelectedItem().toString();
                        value = Integer.parseInt(text);
                        KrediTotal += value;



                    }

                    if (element3 instanceof Spinner) {
                        Spinner elementspinner2 = (Spinner)element3;
                        String text = elementspinner2.getSelectedItem().toString();
                        harf = harfcalculator(text);

                    }
                    Puan+=(value * harf);

                    GNO = (Puan)/KrediTotal;
                    DecimalFormat df = new DecimalFormat("0.00");
                    gnohesaplama.setText(""+df.format(GNO));




                }
                GNO = 0;
                value = 0;
                KrediTotal = 0;
                Puan = 0 ;



            }

        });



    }



}
