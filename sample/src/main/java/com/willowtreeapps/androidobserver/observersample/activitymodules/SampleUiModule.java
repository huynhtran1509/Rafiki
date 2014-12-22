package com.willowtreeapps.androidobserver.observersample.activitymodules;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.willowtreeapps.androidobservables.ActivityObserverImpl;
import com.willowtreeapps.androidobserver.observersample.R;

/**
 * Created by charlie on 12/22/14.
 */
public class SampleUiModule extends ActivityObserverImpl {

    Button mButton;

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        activity.setContentView(R.layout.main);

        mButton = (Button)activity.findViewById(R.id.button);
        final Context appContext = activity.getApplicationContext();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(appContext, "Login clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroy(Activity activity) {
        super.onDestroy(activity);
        mButton = null;
    }
}
