package com.example.idoid.sidra;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    double num1, d;
    int typeprog;
    ListView lv1;
    TextView tv1, tv2, tv3, tv4;
    Double[] numbers=new Double[20];
    String [] numbers2=new String[20];
    Double schum = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1=(TextView)findViewById(R.id.textView7);
        tv2 = (TextView) findViewById(R.id.textView8);
        tv3 = (TextView) findViewById(R.id.textView9);
        tv4 = (TextView) findViewById(R.id.textView10);
        lv1 = (ListView) findViewById(R.id.listview);

        Intent get = getIntent();
        typeprog = get.getIntExtra("typeProg", 666666666);
        num1 = get.getDoubleExtra("firstNum", 6666666);
        d = get.getDoubleExtra("d", 66666666);

        numbers[0] = num1;
        numbers2[0]=""+num1;
        if (typeprog == 1) {
           for (int i = 1; i < 20; i++) {
                numbers[i] = d + numbers[i - 1];
                numbers2[i]=""+numbers[i];


            }
        } else {
            for (int i = 1; i < 20; i++) {
               numbers[i] = d * numbers[i - 1];
                numbers2[i]=""+numbers[i];
            }
        }
        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, numbers2);
          lv1.setAdapter(adp);
    }

   @Override
   public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {
       for (int i = 0; i <= position; i++) {
        schum = schum + numbers[i];
      }
         tv1.setText("" + num1);
          tv2.setText("" + d);
         tv3.setText("" + position);
           tv4.setText("" + schum);

       }
    }


