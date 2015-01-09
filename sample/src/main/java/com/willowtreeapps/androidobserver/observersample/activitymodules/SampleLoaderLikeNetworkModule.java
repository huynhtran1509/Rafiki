package com.willowtreeapps.androidobserver.observersample.activitymodules;

import android.app.Activity;
import android.os.Bundle;

import com.willowtreeapps.androidobservables.ActivityObserverImpl;

import java.util.ArrayList;

/**
 * Created by charlie on 1/9/15.
 * This class better outlines an example of a module that needs to be lifecycle aware and an
 *  implementation of retaining a nonconfiguration object
 *
 * NOTE - There are bad practices/shortcuts in this module. This is purely meant to showcase the
 *  retaining a nonconfiguration object
 */
public class SampleLoaderLikeNetworkModule extends ActivityObserverImpl {

    private ArrayList<HTTPRequest> requests = null;

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        requests = (ArrayList<HTTPRequest>)getLastCustomNonConfigurationInstance(activity);
        if(requests == null) {
            requests = new ArrayList<>();
        }
    }

    @Override
    public String getStaticID() {
        return getClass().getName();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(Activity activity) {
        //Clear out the observers because they need to be destroyed or they will memory leak
        for(HTTPRequest request : requests) {
            request.observer = null;
        }
        return requests;
    }

    public void makeRequest(HTTPRequest request) {
        requests.add(request);

        //In a real scenario you would launch an actual web request and
        // probably give the request to something that wont be destroyed
        // But for example sake we're just going to put it in a thread.
        new Thread(new RunnerThread(request)).start();
    }

    public ArrayList<HTTPRequest> getRequests() {
        return requests;
    }

    @Override
    public void onPause(Activity activity) {
        super.onPause(activity);
        //Here we could throttle down the request if they were in a since they're no longer visible to the user
    }

    @Override
    public void onStop(Activity activity) {

        //Clear out the requests because we won't be using them anymore
        if(!activity.isChangingConfigurations() && activity.isFinishing()) {
            for(HTTPRequest request : requests) {
                request.observer = null;
            }
            requests.clear();
            //You would also cancel the requests here possibly but in this example we will not
        }
    }

    public static class HTTPRequest {
        public String url = null;
        public String response = null;
        public RequestObserver observer = null;

        private boolean finished = false;

        public boolean isFinished() {return finished;}
    }

    public static interface RequestObserver {
        public void onResult(HTTPRequest request);
    }

    private static class RunnerThread implements Runnable {
        public HTTPRequest request;

        private RunnerThread(HTTPRequest request) {
            this.request = request;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000,0);
            } catch (InterruptedException e) {}
            request.response = "This might have come from the internet";
            request.finished = true;
            if(request.observer != null) {
                request.observer.onResult(request);
            }
        }
    }
}
