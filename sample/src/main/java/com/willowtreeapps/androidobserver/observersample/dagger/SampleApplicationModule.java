package com.willowtreeapps.androidobserver.observersample.dagger;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by charlie on 11/22/14.
 */
@Module
public class SampleApplicationModule {

    private final Context mContext;

    public SampleApplicationModule(Context c) {
        mContext = c;
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    public AlarmManager providesAlarmManager() {
        return (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
    }

    @Provides
    public NotificationManager providesNotificationManager() {
        return (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
