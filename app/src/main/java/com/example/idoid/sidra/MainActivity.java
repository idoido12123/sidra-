package com.example.idoid.sidra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1,rb2;
    Button btn1;
    EditText et1,et2;
    Intent t1;
    double num1,d;
    String st;
    int typeProg;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.firstNum);
        et2 = (EditText) findViewById(R.id.MultOrDif);
        rb1 = (RadioButton) findViewById(R.id.aritProg);
        rb2 = (RadioButton) findViewById(R.id.geoProg);
    }

    public void go(View view) {
        t1 = new Intent(this, Main2Activity.class);
        st = et1.getText().toString();
        num1 = Double.parseDouble(st);
        st = et2.getText().toString();
        d = Double.parseDouble(st);
        if (rb1.isChecked()) typeProg=1;
        if (rb2.isChecked()) typeProg=2;
        t1.putExtra("typeProg",typeProg);
        t1.putExtra("firstNum",num1);
        t1.putExtra("d",d);
        startActivity(t1);
    }
}