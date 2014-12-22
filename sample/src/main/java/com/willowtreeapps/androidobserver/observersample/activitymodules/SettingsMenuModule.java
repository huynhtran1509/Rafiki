package com.willowtreeapps.androidobserver.observersample.activitymodules;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.willowtreeapps.androidobservables.ActivityObserverImpl;
import com.willowtreeapps.androidobserver.observersample.R;

/**
 * Created by charlie on 12/22/14.
 */
public class SettingsMenuModule extends ActivityObserverImpl {

    @Override
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        activity.getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
        if(item.getItemId() == R.id.settings) {
            Toast.makeText(activity, "Settings Selected", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
