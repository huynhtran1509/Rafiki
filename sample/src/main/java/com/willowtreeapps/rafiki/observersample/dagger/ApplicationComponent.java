package com.willowtreeapps.rafiki.observersample.dagger;

import com.willowtreeapps.rafiki.observersample.ExampleApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by charlie on 12/2/14.
 */
@Singleton
@Component(modules = SampleApplicationModule.class) public interface ApplicationComponent {
    void inject(ExampleApplication application);
}
