package com.example.loveshayari;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import MyAdapter.GradientAdapter;
import MyAdapter.config;

public class Third_Activity extends AppCompatActivity {

    ImageView img1,img2,img3,copy_icon,back_button,next_button,share_button;
    TextView txt1,txt2;
    GridView gridView;
    int d=0,i,cnt=0,n=1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        txt1=findViewById(R.id.activity_third_page_txt1);
        String shayari[]=getIntent().getStringArrayExtra("shayari");
        int position=getIntent().getIntExtra("pos",0);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        copy_icon=findViewById(R.id.copy_icon);
        back_button=findViewById(R.id.back_button);
        next_button=findViewById(R.id.next_button);
        share_button=findViewById(R.id.share_button);
        txt2=findViewById(R.id.activity_third_page_txt2);


        img1.setImageResource(R.drawable.img_12);
        img2.setImageResource(R.drawable.img_13);
        img3.setImageResource(R.drawable.img_14);
        txt1.setText(""+shayari[position]);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Third_Activity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_gradients);
                GradientAdapter adapter=new GradientAdapter(Third_Activity.this,config.gradientArr);
                gridView=bottomSheetDialog.findViewById(R.id.gridviewGradients);
                gridView.setAdapter(adapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        txt1.setBackgroundResource(config.gradientArr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<15)
                {
                    if (cnt == i) {
                        txt1.setBackgroundResource(config.gradientArr[i]);
                        cnt++;
                        i++;
                    }
                }
                else
                {
                    cnt=0;
                    i=0;
                }

            }
        });
        copy_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy",txt1.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(Third_Activity.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        d=position;
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d>0) {
                    d--;
                    n--;
                    txt1.setText(""+shayari[d]);
                    txt2.setText(""+n+"/"+shayari.length);
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Third_Activity.this,Fourth_Activity.class);
                intent.putExtra("gridcolorarr",config.gradientArr);
                intent.putExtra("shayari",shayari);
                intent.putExtra("d",d);

                startActivity(intent);
            }
        });

        d=position;
        n=d+1;
        txt2.setText(""+n+"/"+shayari.length);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(d<shayari.length-1) {
                    d++;
                    n=d+1;
                    txt1.setText(""+shayari[d]);
                    txt2.setText(""+n+"/"+shayari.length);
                }
            }
        });
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,txt1.getText().toString());
                share.setType("text/plain");
                share = Intent.createChooser(share,"Share Via: ");
                startActivity(share);
            }
        });
    }
}