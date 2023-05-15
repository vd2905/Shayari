package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.loveshayari.MainActivity;
import com.example.loveshayari.R;

public class MyAdapter extends BaseAdapter {
    MainActivity mainActivity;
    int[] imgArr;
    String[] Name;
    public MyAdapter(MainActivity mainActivity, int[] imgArr, String[] Name)
    {
        this.mainActivity=mainActivity;
        this.imgArr=imgArr;
        this.Name=Name;

    }

    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(mainActivity).inflate(R.layout.activity_main_1,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.activity_main1_imgView);
        TextView txt1 = view.findViewById(R.id.activity_main1_txt1);

        imageView.setImageResource(imgArr[position]);
        txt1.setText(""+Name[position]);


        return view;

    }
}
