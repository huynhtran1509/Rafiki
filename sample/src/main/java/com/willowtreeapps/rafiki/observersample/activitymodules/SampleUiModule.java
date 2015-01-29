package com.willowtreeapps.rafiki.observersample.activitymodules;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.willowtreeapps.rafiki.AbstractActivityListener;
import com.willowtreeapps.rafiki.observersample.R;

import java.util.ArrayList;

/**
 * Created by charlie on 12/22/14.
 */
public class SampleUiModule extends AbstractActivityListener {

    private final SampleLoaderLikeNetworkModule mLoaderModule;
    Button mButton;

    public SampleUiModule(SampleLoaderLikeNetworkModule loaderModule) {
        mLoaderModule = loaderModule;
    }

    @Override
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        activity.setContentView(R.layout.main);

        mButton = (Button)activity.findViewById(R.id.button);
        final Context appContext = activity.getApplicationContext();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(appContext, "Login clicked", Toast.LENGTH_LONG).show();

                //Simulate a login
                SampleLoaderLikeNetworkModule.HTTPRequest request = new SampleLoaderLikeNetworkModule.HTTPRequest();
                request.url = "www.google.com";

                request.observer = new SampleLoaderLikeNetworkModule.RequestObserver() {
                    @Override
                    public void onResult(SampleLoaderLikeNetworkModule.HTTPRequest request) {
                        //The observer is cleared out when the activity is destroyed so there is no leak
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(appContext, "Login completed", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                };
                mLoaderModule.makeRequest(request);
            }
        });
    }

    @Override
    public void onResume(final Activity activity) {
        //Lets check the requests to see if we already made a login attempt
        ArrayList<SampleLoaderLikeNetworkModule.HTTPRequest> requests = mLoaderModule.getRequests();
        for(SampleLoaderLikeNetworkModule.HTTPRequest request : requests) {
            if(request.isFinished()) {
                Toast.makeText(activity, "Login completed", Toast.LENGTH_LONG).show();
            } else {
               final Context appContext = activity.getApplicationContext();
                //There is a race condition here. In a real implementation there would
                // have to be appropriate synchronization
               request.observer = new SampleLoaderLikeNetworkModule.RequestObserver() {
                    @Override
                    public void onResult(SampleLoaderLikeNetworkModule.HTTPRequest request) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(appContext, "Login completed", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                };
            }
        }
    }

    @Override
    public void onDestroy(Activity activity) {
        super.onDestroy(activity);
        mButton = null;
    }
}
