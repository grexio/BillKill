package io.grex.billkill.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.grex.billkill.app.R;

public class OverviewFragment extends Fragment {

    @InjectView(R.id.listView_friends)
    ListView mListView;
    @InjectView(R.id.textView_balance_value)
    TextView mTextViewBal;

    String[] names = {"Javed", "Dheeraj", "Imran", "Phani"};

    public static OverviewFragment getInstance() {
        return new OverviewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_overview, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);

        mTextViewBal.setText("5000");
        mListView.setAdapter(new ListViewAdapter());
    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.item_list_friend, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            String name = (String) getItem(position);
            holder.mImageView.setImageResource(R.drawable.ic_launcher);
            holder.mTextViewName.setText(name);
            holder.mTextViewAmount.setText("20.00");
            return convertView;
        }
    }

    public class ViewHolder {
        @InjectView(R.id.imageView_picture)
        ImageView mImageView;
        @InjectView(R.id.textView_name)
        TextView mTextViewName;
        @InjectView(R.id.textView_amount)
        TextView mTextViewAmount;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}

