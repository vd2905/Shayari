package com.example.loveshayari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import MyAdapter.GradientAdapter1;
import MyAdapter.TextcolorAdapter;
import MyAdapter.config;

public class Fourth_Activity extends AppCompatActivity {

    TextView textView;
    ImageView img1,img2;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    int a=0,count=0,i,cnt=0,z=1;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);
        textView=findViewById(R.id.activity_fourth_page_txt1);
        img1=findViewById(R.id.activity_fourth_page_img1);
        img2=findViewById(R.id.activity_fourth_page_img2);
        btn1=findViewById(R.id.activity_fourth_page_btn1);
        btn2=findViewById(R.id.activity_fourth_page_btn2);
        btn3=findViewById(R.id.activity_fourth_page_btn3);
        btn4=findViewById(R.id.activity_fourth_page_btn4);
        btn5=findViewById(R.id.activity_fourth_page_btn5);
        btn6=findViewById(R.id.activity_fourth_page_btn6);

        int position=getIntent().getIntExtra("pos",0);
        String Shayari[]=getIntent().getStringArrayExtra("shayari");
        textView.setText(""+Shayari[position]);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<15) {
                    if (cnt == i) {
                        textView.setBackgroundResource(config.gradientArr[i]);
                        cnt++;
                        i++;
                    }
                }else{
                    cnt=0;
                    i=0;
                }

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_gradients);
                GradientAdapter1 adapter1=new GradientAdapter1(Fourth_Activity.this,config.gradientArr);
                gridView=bottomSheetDialog.findViewById(R.id.gridviewGradients);
                gridView.setAdapter(adapter1);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(config.gradientArr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.bg_color);
                TextcolorAdapter adapter=new TextcolorAdapter(Fourth_Activity.this,config.colorArr);
                gridView=bottomSheetDialog.findViewById(R.id.bg_gridview);
                gridView.setAdapter(adapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(config.colorArr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.text_color);
                TextcolorAdapter adapter=new TextcolorAdapter(Fourth_Activity.this,config.colorArr1);
                gridView=bottomSheetDialog.findViewById(R.id.text_color_gridview);
                gridView.setAdapter(adapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setTextColor(getResources().getColor(config.colorArr1[i]));
                        bottomSheetDialog.dismiss();
                    }
                });

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,textView.getText().toString());
                share.setType("text/plain");
                share = Intent.createChooser(share,"Share Via: ");
                startActivity(share);
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