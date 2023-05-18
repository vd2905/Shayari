package MyAdapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loveshayari.Fourth_Activity;
import com.example.loveshayari.R;

public class FontAdapter extends BaseAdapter {

    Fourth_Activity fourth_activity;
    String[] fontArr;

    public FontAdapter(Fourth_Activity fourth_activity, String[] fontArr)
    {
        this.fourth_activity = fourth_activity;
        this.fontArr = fontArr;
    }

    @Override
    public int getCount() {
        return fontArr.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(fourth_activity).inflate(R.layout.font_item,parent,false);
        Typeface typeface = Typeface.createFromAsset(fourth_activity.getAssets(),fontArr[position]);
        TextView textView = convertView.findViewById(R.id.fonts);
        textView.setText("शायरी");
        textView.setTypeface(typeface);
        return convertView;
    }
}
