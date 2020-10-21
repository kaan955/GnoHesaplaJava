package com.example.kaan.myapplication;


        import android.support.constraint.ConstraintLayout;
        import android.support.constraint.ConstraintSet;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.DisplayMetrics;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ScrollView;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.text.DecimalFormat;

        import static com.example.kaan.myapplication.StartPage.a;
        import static com.example.kaan.myapplication.StartPage.güncelkredisayı;
        import static com.example.kaan.myapplication.StartPage.güncelgnosayı;
        import static com.example.kaan.myapplication.StartPage.radiogroupnum;


public class Mytry extends AppCompatActivity {



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

    public static double GNO = 0.0;
    public static double KrediTotal = 0.0;
    public static double Puan = 0.0;

    private EditText etxt;
    private Spinner spinner,spinnera;
    private TextView yno,gno,kredisayı,gnotext,ynotext,kreditext,sabittxt,sabittxt2,sabittxt3;
    private Button btnhesap;
    private ScrollView sv,sc;
    private ConstraintLayout layout,layout2,layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.mytry);
        sv = new ScrollView(this);

       layout =  findViewById(R.id.consta);
       layout2 = findViewById(R.id.constb);

        layout3 = new ConstraintLayout(this);

        sc = findViewById(R.id.myscoll);

        ConstraintSet set = new ConstraintSet();
        set.clone(layout2);

        ConstraintSet set2 = new ConstraintSet();
        set2.clone(layout);


        yno = findViewById(R.id.yno);
        gno = findViewById(R.id.gno);
        kredisayı = findViewById(R.id.kredisayı);

        ynotext = findViewById(R.id.ynotext);
        gnotext = findViewById(R.id.gnotext);
        kredisayı = findViewById(R.id.kreditext);

        btnhesap = findViewById(R.id.hesapbtn);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);





        System.out.println(Math.round(Math.round(metrics.density))+"\n"+"Orijinal: " + (metrics.density));

        int logicalDensity = Math.round(metrics.density);

        int j = 0;
        sabittxt = new TextView(this);
        sabittxt.setId(j++);
        sabittxt.setText("Ders");
        sabittxt.setTextSize(15);

        layout.addView(sabittxt);

        sabittxt2 =  new TextView(this);
        sabittxt2.setId(j++);
        sabittxt2.setText("HARF");
        sabittxt2.setTextSize(15);
        layout.addView(sabittxt2);

        sabittxt3=  new TextView(this);
        sabittxt3.setId(j++);
        sabittxt3.setText("KREDI");
        sabittxt3.setTextSize(15);
        layout.addView(sabittxt3);

        set2.connect(sabittxt.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 10*logicalDensity);
        set2.connect(sabittxt2.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 10*logicalDensity);
        set2.connect(sabittxt3.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 10*logicalDensity);

        set2.connect(sabittxt.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 20*logicalDensity);
        set2.connect(sabittxt2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 200*logicalDensity);
        set2.connect(sabittxt3.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 100*logicalDensity);

        set2.constrainHeight(sabittxt.getId(), 50*logicalDensity);
        set2.constrainWidth(sabittxt.getId(), 120*logicalDensity);
        set2.constrainHeight(sabittxt2.getId(), 50*logicalDensity);
        set2.constrainWidth(sabittxt2.getId(), 120*logicalDensity);
        set2.constrainHeight(sabittxt3.getId(), 50*logicalDensity);
        set2.constrainWidth(sabittxt3.getId(), 120*logicalDensity);

        set2.applyTo(layout);
        //Button 1:
        int counter = 0;
        for(int i = 0 ; i < a ; i++)
        {


        //////////TXT PLACE //////////////

            etxt = new EditText(this);
            etxt.setId(counter++);

            etxt.setHint(i+1 + ". Ders");
            etxt.setTextSize(12);
            layout2.addView(etxt);

            /////// SPINNER KREDI /////////////////

            spinner = new Spinner(this);
            spinner.setId(counter++);
            ArrayAdapter adapters = ArrayAdapter.createFromResource(this,R.array.kredi,android.R.layout.simple_dropdown_item_1line );
            spinner.setAdapter(adapters);
            layout2.addView(spinner);


            ///// SPİNNER HARF ////////

            spinnera = new Spinner(this);
            spinnera.setId(counter++);
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
            layout2.addView(spinnera);



                    set.connect(etxt.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50 * i * logicalDensity);
                    set.connect(spinner.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50 * i *logicalDensity);
                    set.connect(spinnera.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50 * i *logicalDensity);


                    set.connect(etxt.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 20*logicalDensity);
                    set.connect(spinnera.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 200*logicalDensity);
                    set.connect(spinner.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 100*logicalDensity);



                    set.constrainHeight(etxt.getId(), 40*logicalDensity);
                    set.constrainWidth(etxt.getId(), 80*logicalDensity);

                    set.constrainHeight(spinner.getId(), 40*logicalDensity);
                    set.constrainWidth(spinner.getId(), 100*logicalDensity);

                    set.constrainHeight(spinnera.getId(),40*logicalDensity);
                    set.constrainWidth(spinnera.getId(), 100*logicalDensity);



            set.applyTo(layout2);
        }



btnhesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = 0.0, harf = 0.0;

                int loop = 0;

                for (int j = 0; j < a * 3; j++) {
                    View element = layout2.getChildAt(j);


                    if (element instanceof Spinner) {
                            int b = j-(3*loop);
                        if (b == 1) {
                            loop++;
                            Spinner elementspinner = (Spinner) element;
                            String text = elementspinner.getSelectedItem().toString();
                            value = Double.parseDouble(text);
                            KrediTotal += value;
                            j++;
                            View element2 = layout2.getChildAt(j);


                            Spinner elementspinner2 = (Spinner) element2;
                            String text2 = elementspinner2.getSelectedItem().toString();
                            harf = harfcalculator(text2);


                        }

                        Puan += (value * harf);
                        //YNO
                        GNO = (Puan) / KrediTotal;
                        DecimalFormat df = new DecimalFormat("0.00");
                        ynotext.setText("" + df.format(GNO));
                        kredisayı.setText(" "+ KrediTotal);


                                    //GNO
                        if(j == (a * 3) - 1 ) {
                            Puan += (güncelgnosayı * güncelkredisayı);
                            KrediTotal += güncelkredisayı;
                            GNO = (Puan) / KrediTotal;

                            gnotext.setText("" + df.format(GNO));
                            kredisayı.setText(" " + KrediTotal);
                        }

                    }


                }






                GNO = 0;
                value = 0;
                KrediTotal = 0;
                Puan = 0;
                loop = 0;

            }

        });


    }

}