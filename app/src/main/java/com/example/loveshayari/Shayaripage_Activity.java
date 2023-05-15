package com.example.loveshayari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loveshayari.R;

public class Shayaripage_Activity extends AppCompatActivity {

    ImageView img1,img2,img3,img4,img5,img6,img7;
    TextView txt1;
    GridView gridView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayaripage);

        txt1=findViewById(R.id.txt1);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        gridView=findViewById(R.id.grid1);

        int position=getIntent().getIntExtra("pos",0);
        String shayari[]=getIntent().getStringArrayExtra("shayari");
        txt1.setText(""+shayari[position]);

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
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Shayaripage_Activity.this,Fourth_Activity.class);
                intent.putExtra("pos",position);
                intent.putExtra("shayari",shayari);
                startActivity(intent);

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}