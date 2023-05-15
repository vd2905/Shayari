package com.example.loveshayari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fourth_Activity extends AppCompatActivity {

    TextView textView;
    ImageView img1,img2;
    Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        textView=findViewById(R.id.activity_fourth_txt1);
        img1=findViewById(R.id.activity_fourth_img1);
        img2=findViewById(R.id.activity_fourth_img2);
        btn1=findViewById(R.id.activity_fourth_btn1);
        btn2=findViewById(R.id.activity_fourth_btn2);
        btn3=findViewById(R.id.activity_fourth_btn3);
        btn4=findViewById(R.id.activity_fourth_btn4);
        btn5=findViewById(R.id.activity_fourth_btn5);
        btn6=findViewById(R.id.activity_fourth_btn6);

        int position=getIntent().getIntExtra("pos",0);
        String shayari[]=getIntent().getStringArrayExtra("shayari");
        textView.setText(""+shayari[position]);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}