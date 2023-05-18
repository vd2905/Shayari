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
    int[] colorArr1;

    public TextcolorAdapter(Fourth_Activity fourth_activity, int[] colorArr1)
    {
        this.fourth_activity = fourth_activity;
        this.colorArr1 = colorArr1;
    }

    @Override
    public int getCount() {
        return colorArr1.length;
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
        convertView = LayoutInflater.from(fourth_activity).inflate(R.layout.text_color_item,parent,false);
        TextView textView = convertView.findViewById(R.id.text_color);

        textView.setBackgroundResource(colorArr1[position]);
        return convertView;
    }
}
