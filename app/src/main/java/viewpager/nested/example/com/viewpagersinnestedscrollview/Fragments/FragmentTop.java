package viewpager.nested.example.com.viewpagersinnestedscrollview.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import viewpager.nested.example.com.viewpagersinnestedscrollview.R;
import viewpager.nested.example.com.viewpagersinnestedscrollview.Utilities.Constants;

public class FragmentTop extends Fragment {

    private TextView textView;
    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_top, container, false);
        textView = (TextView) v.findViewById(R.id.top_text);

        if (getArguments() != null) {
            text = getArguments().getString(Constants.TEXT);
        }

        textView.setText(text);

        return v;
    }
}
