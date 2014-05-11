package io.grex.billkill.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.grex.billkill.app.R;

public class NewBillFragment extends Fragment {

    public static NewBillFragment getInstance() {
        return new NewBillFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_new_bill, null, false);
    }
}
