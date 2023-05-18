package com.example.loveshayari;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

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
    String[] shayari;
    int d,i=0,cnt=0;
    GridView gridView,gridView1,gridView2,gridView3;
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
        shayari = getIntent().getStringArrayExtra("shayari");
        d = getIntent().getIntExtra("d",0);
        textView.setText(""+shayari[d]);

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
                TextcolorAdapter adapter3 = new TextcolorAdapter(Fourth_Activity.this,config.colorArr1);
                gridView2 = bottomSheetDialog.findViewById(R.id.text_color_gridview);
                gridView2.setAdapter(adapter3);
                bottomSheetDialog.show();
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        textView.setTextColor(getResources().getColor(config.colorArr1[position]));
                        bottomSheetDialog.dismiss();
                    }
                });
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
                        bottomSheetDialog.dismiss();
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
                EmojiAdapter adapter5 = new EmojiAdapter(Fourth_Activity.this,config.emoji);
                listView = bottomSheetDialog.findViewById(R.id.emoji_listview);
                listView.setAdapter(adapter5);
                bottomSheetDialog.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(""+config.emoji[position]+"\n"+shayari[position]+"\n"+config.emoji[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_text_size);
                SeekBar seekBar = bottomSheetDialog.findViewById(R.id.seekBar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textView.setTextSize(2,20+i);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                bottomSheetDialog.show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            private File downloadFile;

            @Override
            public void onClick(View v)
            {
                Bitmap icon = getBitmapFromView(textView);
                Intent share =new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int num=new Random().nextInt(2000);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());

                downloadFile= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                try
                {
                    downloadFile.createNewFile();
                    FileOutputStream fo = new FileOutputStream(downloadFile);
                    fo.write(bytes.toByteArray());
                    Toast.makeText(Fourth_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadFile.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));

            }
        });
    }
    private Bitmap getBitmapFromView(TextView textView)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(textView.getWidth(), textView.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = textView.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        textView.draw(canvas);
        //return the bitmap
        return returnedBitmap;

    }
}

