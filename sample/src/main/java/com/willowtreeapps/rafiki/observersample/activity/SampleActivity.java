package com.willowtreeapps.rafiki.observersample.activity;

import com.willowtreeapps.rafiki.DispatchFragmentActivity;
import com.willowtreeapps.rafiki.observersample.activitymodules.SampleLoaderLikeNetworkModule;
import com.willowtreeapps.rafiki.observersample.activitymodules.SampleUiModule;
import com.willowtreeapps.rafiki.observersample.activitymodules.SettingsMenuModule;

/**
 * Created by charlie on 12/22/14.
 */
public class SampleActivity extends DispatchFragmentActivity {

    public SampleActivity() {
        super();
        SampleLoaderLikeNetworkModule loaderModule = new SampleLoaderLikeNetworkModule();
        addObserver(loaderModule);
        addObserver(new SampleUiModule(loaderModule));
        addObserver(new SettingsMenuModule());
    }
}
