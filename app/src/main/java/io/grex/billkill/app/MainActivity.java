package io.grex.billkill.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add_new_bill) {
            Intent intent = new Intent(this, NewBillActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_logout) {
            PreferencesManager.getInstance().remove(CHECK_REGISTRATION);
            /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, RegisterFragment.getInstance());
            getActionBar().hide();
            transaction.commitAllowingStateLoss();*/
            Intent intent = getIntent();
        finish();
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
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
