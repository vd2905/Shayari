package com.example.loveshayari;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import MyAdapter.BgAdapter;
import MyAdapter.EmojiAdapter;
import MyAdapter.FontAdapter;
import MyAdapter.GradientAdapter1;
import MyAdapter.TextcolorAdapter;
import MyAdapter.config;

public class Fourth_Activity extends AppCompatActivity {

    TextView textView;
    ImageView img1,img2;
    ListView listView;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    int d,i=0,cnt=0;
    GridView gridView,gridView1,gridView2,gridView3,gridView4;
    int[] gridcolorarr;
    int[] position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);

        textView=findViewById(R.id.activity_fourth_page_txt1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        img1=findViewById(R.id.activity_fourth_page_img1);
        img2=findViewById(R.id.activity_fourth_page_img2);

        gridcolorarr = getIntent().getIntArrayExtra("gridcolorarr");
        String Shayari[]=getIntent().getStringArrayExtra("shayari");
        d = getIntent().getIntExtra("d",0);
        textView.setText(""+Shayari[d]);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<15) {
                    if (cnt == i) {
                        textView.setBackgroundResource(gridcolorarr[i]);
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
            public void onClick(View v)
            {
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
                BgAdapter adapter2 = new BgAdapter(Fourth_Activity.this,config.colorArr);
                gridView1=bottomSheetDialog.findViewById(R.id.bg_gridview);
                gridView1.setAdapter(adapter2);
                bottomSheetDialog.show();
                gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        textView.setBackgroundResource(config.colorArr[position]);
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
                TextcolorAdapter adapter3 = new TextcolorAdapter(Fourth_Activity.this,config.colorArr);
                gridView2 = bottomSheetDialog.findViewById(R.id.text_color_gridview);
                gridView2.setAdapter(adapter3);
                bottomSheetDialog.show();
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        textView.setTextColor(getResources().getColor(config.colorArr[position]));
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
        btn4.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_font);
                FontAdapter adapter4 = new FontAdapter(Fourth_Activity.this,config.fontArr);
                gridView3 = bottomSheetDialog.findViewById(R.id.fonts_gridview);
                gridView3.setAdapter(adapter4);
                bottomSheetDialog.show();
                gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Typeface typeface = Typeface.createFromAsset(getAssets(),config.fontArr[position]);
                        textView.setTypeface(typeface);
                    }
                });
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_emoji);
                EmojiAdapter adapter4 = new EmojiAdapter(Fourth_Activity.this,config.emoji);
                listView = bottomSheetDialog.findViewById(R.id.emoji_listview);
                listView.setAdapter(adapter4);
                bottomSheetDialog.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(""+config.emoji[position]+"\n"+Shayari[position]+"\n"+config.emoji[position]);
                        bottomSheetDialog.dismiss();
                    }
                });

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.text_color);

            }
        });


    }
}