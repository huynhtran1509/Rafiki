package com.willowtreeapps.rafiki.observersample.mockutils;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.willowtreeapps.rafiki.ActivityListener;
import com.willowtreeapps.rafiki.DispatchActivity;
import com.willowtreeapps.rafiki.observersample.ExampleApplication;
import com.willowtreeapps.rafiki.observersample.R;
import com.willowtreeapps.rafiki.observersample.dagger.ApplicationComponent;
import com.willowtreeapps.rafiki.observersample.dagger.Dagger_ApplicationComponent;
import com.willowtreeapps.rafiki.observersample.dagger.SampleApplicationModule;
import com.squareup.okhttp.OkHttpClient;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Created by charlie on 12/9/14.
 */
public class MockGenerator {

    public static DispatchActivity getMockActivity(ActivityListener observer) {
        //Loop through the fields of the observer and set up the views so that they can be found through activity.findViewByID();
        DispatchActivity activity = mock(DispatchActivity.class);

        //tmp hack for demo. It would be better to build this out into a framework that actually used the XML files
        final HashMap<Integer, View> map = new HashMap<>();
        map.put(R.id.button, mock(Button.class));

        Context c = MockGenerator.getMockApplicationContext();

        //Set up the injection mocker
        when(activity.getApplicationContext()).thenReturn(c);

        //Set up the activity to use the map when findViewById is called
        when(activity.findViewById(anyInt())).thenAnswer(new Answer<View>() {
            @Override
            public View answer(InvocationOnMock invocation) throws Throwable {
                return map.get(invocation.getArgumentAt(0, Integer.class));
            }
        });

        return activity;
    }

    public static Context getMockApplicationContext() {
        //We need to setup dagger here for injection with a mock module
        ExampleApplication application = mock(ExampleApplication.class);

        //Set up all of the mock injectable objects
        SampleApplicationModule sampleApplicationModule = mock(SampleApplicationModule.class);
        AlarmManager manager = mock(AlarmManager.class);
        OkHttpClient okHttpClient = mock(OkHttpClient.class);
        NotificationManager notificationManager = mock(NotificationManager.class);

        //Set up the conditions to return them
        when(sampleApplicationModule.providesAlarmManager()).thenReturn(manager);
        when(sampleApplicationModule.providesOkHttpClient()).thenReturn(okHttpClient);
        when(sampleApplicationModule.providesNotificationManager()).thenReturn(notificationManager);

        //Set up the component to use our module
        ApplicationComponent component = Dagger_ApplicationComponent.builder()
                .sampleApplicationModule(sampleApplicationModule)
                .build();

        when(application.component()).thenReturn(component);

        return application;
    }
}
