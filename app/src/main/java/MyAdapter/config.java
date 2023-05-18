package MyAdapter;

import android.os.Environment;

import com.example.loveshayari.R;

import java.io.File;

public class config
{
    public static int[] gradientArr = {R.drawable.gc1,R.drawable.gc2,R.drawable.gc3,R.drawable.gc4,R.drawable.gc5,R.drawable.gc6,
            R.drawable.gc7,R.drawable.gc8,R.drawable.gc9,R.drawable.gc10,
            R.drawable.gc11,R.drawable.gc12,R.drawable.gc13,R.drawable.gc14,R.drawable.gc15};
    public static int[] colorArr = {R.color.color_1,R.color.color_2,R.color.color_3,R.color.color_4,R.color.color_5,R.color.color_6,R.color.color_7,R.color.color_8,R.color.color_9,R.color.color_10,R.color.color_11,R.color.color_12,R.color.color_13,R.color.color_14,R.color.color_15};
    public static int[] colorArr1 = {R.color.color_2,R.color.color_1,R.color.color_4,R.color.color_3,R.color.color_6,R.color.color_5,R.color.color_8,R.color.color_7,R.color.color_10,R.color.color_9,R.color.color_12,R.color.color_11,R.color.color_15,R.color.color_13,R.color.color_14};
    public static String[] fontArr = {"OpenSans-Bold.ttf","OpenSans-BoldItalic.ttf","OpenSans-ExtraBold.ttf","OpenSans-ExtraBoldItalic.ttf","OpenSans-Italic.ttf","OpenSans-Light.ttf","OpenSans-LightItalic.ttf","OpenSans-Regular.ttf","OpenSans-Semibold.ttf","OpenSans-SemiboldItalic.ttf"};
    public static String emoji[] = {"😀😁😂🤣😃😄","😋😊😉😆😅😍","😘🥰😗😙🥲🤔","🤩🤗🙂☺😚🤨","😐😑😶😶‍🌫️🙄","😯🤐😮😥😣😏","❣💕💞💓💗💖","❤️🧡💛💚💙💜"};
    public static File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

}
