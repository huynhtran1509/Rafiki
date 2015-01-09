package com.willowtreeapps.androidobserver.observersample.activity;

import com.willowtreeapps.androidobservables.ObservableActionBarActivity;
import com.willowtreeapps.androidobservables.ObservableFragmentActivity;
import com.willowtreeapps.androidobserver.observersample.activitymodules.SampleLoaderLikeNetworkModule;
import com.willowtreeapps.androidobserver.observersample.activitymodules.SampleUiModule;
import com.willowtreeapps.androidobserver.observersample.activitymodules.SettingsMenuModule;

/**
 * Created by charlie on 12/22/14.
 */
public class SampleActivity extends ObservableFragmentActivity {

    public SampleActivity() {
        super();
        SampleLoaderLikeNetworkModule loaderModule = new SampleLoaderLikeNetworkModule();
        addObserver(loaderModule);
        addObserver(new SampleUiModule(loaderModule));
        addObserver(new SettingsMenuModule());
    }
}
