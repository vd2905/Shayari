package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loveshayari.R;
import com.example.loveshayari.Third_Activity;

public class GradientAdapter extends BaseAdapter {

    Third_Activity third_activity;
    int[] gradientArr;

    public GradientAdapter(Third_Activity third_activity, int[] gradientArr) {
        this.third_activity = third_activity;
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

        convertView = LayoutInflater.from(third_activity).inflate(R.layout.bottom_sheet_gradients1,parent,false);
        TextView textView = convertView.findViewById(R.id.gridGradients);

        textView.setBackgroundResource(gradientArr[position]);
        return convertView;
    }
}
