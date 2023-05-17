package MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loveshayari.Fourth_Activity;
import com.example.loveshayari.R;

public class EmojiAdapter extends BaseAdapter {

    Fourth_Activity fourth_activity;
    String[] emoji;

    public EmojiAdapter(Fourth_Activity fourth_activity, String[] emoji) {
        this.fourth_activity = fourth_activity;
        this.emoji = emoji;
    }

    @Override
    public int getCount() {
        return emoji.length;
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
        convertView = LayoutInflater.from(fourth_activity).inflate(R.layout.emoji_item,parent,false);

        TextView textView = convertView.findViewById(R.id.emoji_textview);
        textView.setText(""+emoji[position]);
        return convertView;
    }
}
