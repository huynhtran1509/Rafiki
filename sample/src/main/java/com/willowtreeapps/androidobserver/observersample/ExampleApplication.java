package com.willowtreeapps.androidobserver.observersample;

import android.app.Application;

import com.willowtreeapps.androidobserver.observersample.dagger.ApplicationComponent;
import com.willowtreeapps.androidobserver.observersample.dagger.ApplicationComponentReturner;
import com.willowtreeapps.androidobserver.observersample.dagger.Dagger_ApplicationComponent;
import com.willowtreeapps.androidobserver.observersample.dagger.SampleApplicationModule;

/**
 * Created by charlie on 11/22/14.
 */
public class ExampleApplication extends Application implements ApplicationComponentReturner {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = Dagger_ApplicationComponent.builder()
                .sampleApplicationModule(new SampleApplicationModule(this))
                .build();
    }

    @Override
    public ApplicationComponent component(){
        return mComponent;
    }
}
