package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loveshayari.Fourth_Activity;
import com.example.loveshayari.R;

public class TextcolorAdapter extends BaseAdapter {

    Fourth_Activity fourth_activity;
    int[] colorArr;

    public TextcolorAdapter(Fourth_Activity fourth_activity, int[] colorArr)
    {
        this.fourth_activity = fourth_activity;
        this.colorArr = colorArr;
    }

    @Override
    public int getCount() {
        return colorArr.length;
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = LayoutInflater.from(fourth_activity).inflate(R.layout.bg_color_item,parent,false);
        TextView textView = convertView.findViewById(R.id.background);

        textView.setText(""+colorArr[position]);
        return convertView;
    }
}
