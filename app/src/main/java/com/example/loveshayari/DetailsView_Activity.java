package com.example.loveshayari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import MyAdapter.MyAdapter1;

public class DetailsView_Activity extends AppCompatActivity {

    ListView listView1;
    //int imgArr[]={R.drawable.img,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9};
    String shayari[];
    MyAdapter1 adapter1;
    int imgArr;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        listView1=findViewById(R.id.listView1);
        shayari=getIntent().getStringArrayExtra("shayari");
        imgArr=getIntent().getIntExtra("image",0);

        adapter1 = new MyAdapter1(DetailsView_Activity.this,imgArr,shayari);
        listView1.setAdapter(adapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(DetailsView_Activity.this,Shayaripage_Activity.class);
                intent.putExtra("pos",position);
                intent.putExtra("shayari",shayari);
                startActivity(intent);
            }
        });

    }
}