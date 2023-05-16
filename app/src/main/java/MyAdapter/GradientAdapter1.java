package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loveshayari.Fourth_Activity;
import com.example.loveshayari.R;

public class GradientAdapter1 extends BaseAdapter {

    Fourth_Activity fourth_activity;
    int[] gradientArr;

    public GradientAdapter1(Fourth_Activity fourth_activity, int[] gradientArr) {
        this.fourth_activity = fourth_activity;
        this.gradientArr = gradientArr;
    }

    @Override
    public int getCount() {
        return gradientArr.length;
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

        convertView = LayoutInflater.from(fourth_activity).inflate(R.layout.bottom_sheet_gradients1,parent,false);
        TextView textView = convertView.findViewById(R.id.gridGradients);

        textView.setText(""+gradientArr[position]);
        return convertView;
    }
}
