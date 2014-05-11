package io.grex.billkill.app;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import io.grex.billkill.app.fragments.OverviewFragment;
import io.grex.billkill.app.fragments.RegisterFragment;

public class MainActivity extends BaseActivity implements RegisterFragment.RegisterListener {

    private final String CHECK_REGISTRATION = "BILL_KILL_REGISTERED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isRegistered = PreferencesManager.getInstance().getBoolean(CHECK_REGISTRATION, false);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!isRegistered) {
            RegisterFragment frag = RegisterFragment.getInstance();
            frag.setRegisterListener(this);
            transaction.add(R.id.fragment_container, frag);
            transaction.commit();
        } else {
            transaction.add(R.id.fragment_container, OverviewFragment.getInstance());
            transaction.commit();
        }
    }


    @Override
    public void onRegistered() {
        PreferencesManager.getInstance().setBoolean(CHECK_REGISTRATION, true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, OverviewFragment.getInstance());
        getActionBar().show();
        transaction.commitAllowingStateLoss();
    }
}
