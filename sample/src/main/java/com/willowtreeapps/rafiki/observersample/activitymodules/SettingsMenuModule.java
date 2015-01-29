package com.willowtreeapps.rafiki.observersample.activitymodules;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.willowtreeapps.rafiki.AbstractActivityListener;
import com.willowtreeapps.rafiki.observersample.R;

/**
 * Created by charlie on 12/22/14.
 */
public class SettingsMenuModule extends AbstractActivityListener {

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
