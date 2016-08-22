package viewpager.nested.example.com.viewpagersinnestedscrollview.Utilities;

import java.util.ArrayList;

public class Constants {
    public static String TEXT = "TEXT";

    public static ArrayList<String> myArrayList = new ArrayList<String>();

    public static void buildGlobalArrayList() {
        for (int i = 0; i < 10; i++) {
            myArrayList.add("Some text " + i);
        }
    }
}
