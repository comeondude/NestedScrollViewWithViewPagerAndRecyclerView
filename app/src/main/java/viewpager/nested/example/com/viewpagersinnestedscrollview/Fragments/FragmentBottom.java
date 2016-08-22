package viewpager.nested.example.com.viewpagersinnestedscrollview.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import viewpager.nested.example.com.viewpagersinnestedscrollview.R;
import viewpager.nested.example.com.viewpagersinnestedscrollview.Utilities.Constants;

public class FragmentBottom extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_bottom, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public MyAdapter() {
        }

        public class NormalViewHolder extends ViewHolder {
            public NormalViewHolder(View itemView) {
                super(itemView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Do whatever you want on clicking the normal items
                    }
                });
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v;

            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            NormalViewHolder vh = new NormalViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            try {
                if (holder instanceof NormalViewHolder) {
                    NormalViewHolder vh = (NormalViewHolder) holder;

                    vh.bindView(position);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            if (Constants.myArrayList == null) {
                return 0;
            }

            return Constants.myArrayList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView listTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                listTextView = (TextView) itemView.findViewById(R.id.list_text);
            }

            public void bindView(int position) {
                listTextView.setText(Constants.myArrayList.get(position));
            }
        }
    }

}
