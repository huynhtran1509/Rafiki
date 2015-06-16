package com.willowtreeapps.rafiki.observersample;

import android.app.Application;

import com.willowtreeapps.rafiki.observersample.dagger.ApplicationComponent;
import com.willowtreeapps.rafiki.observersample.dagger.ApplicationComponentReturner;
import com.willowtreeapps.rafiki.observersample.dagger.DaggerApplicationComponent;
import com.willowtreeapps.rafiki.observersample.dagger.SampleApplicationModule;

/**
 * Created by charlie on 11/22/14.
 */
public class ExampleApplication extends Application implements ApplicationComponentReturner {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .sampleApplicationModule(new SampleApplicationModule(this))
                .build();
    }

    @Override
    public ApplicationComponent component(){
        return mComponent;
    }
}
