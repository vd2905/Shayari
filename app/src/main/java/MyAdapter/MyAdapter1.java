package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loveshayari.DetailsView_Activity;
import com.example.loveshayari.R;

public class MyAdapter1 extends BaseAdapter {

    DetailsView_Activity detailsView_activity;
    int imgArr;
    String shayari[];

    public MyAdapter1(DetailsView_Activity detailsView_activity, int imgArr, String[] shayari)
    {
        this.detailsView_activity=detailsView_activity;
        this.imgArr=imgArr;
        this.shayari=shayari;
    }

    @Override
    public int getCount() {
        return shayari.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(detailsView_activity).inflate(R.layout.activity_details_view1,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.activity_details1_view1_imgView);
        TextView txt1 = view.findViewById(R.id.activity_details_view1_txt1);

        imageView.setImageResource(imgArr);
        txt1.setText(""+shayari[position]);

        return view;
    }
}
