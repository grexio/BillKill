package io.grex.billkill.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PreferencesManager.initializeInstance(getApplicationContext());
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(getString(R.string.font));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }
}
