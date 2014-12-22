package com.willowtreeapps.androidobservables;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import java.util.ArrayList;

/**
 * Created by charlie on 12/14/14.
 */
public class ObservableSupportFragment extends Fragment {

    private ArrayList<SupportFragmentObserver> mObservers = new ArrayList<SupportFragmentObserver>();
    private boolean mIsPaused = true;

    public void addObserver(SupportFragmentObserver observer) {
        mObservers.add(observer);
    }

    public void removeObserver(SupportFragmentObserver observer) {
        mObservers.remove(observer);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean result = false;
        for (SupportFragmentObserver observer : mObservers) {
            if (result) {
                observer.onContextItemSelected(this, item);
            } else {
                result = observer.onContextItemSelected(this, item);
            }
        }

        if (result) {
            super.onContextItemSelected(item);
        } else {
            result = super.onContextItemSelected(item);
        }

        return result;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        for (SupportFragmentObserver observer : mObservers) {
                observer.onHiddenChanged(this, hidden);
        }
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onInflate(this, activity, attrs, savedInstanceState);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onAttach(this, activity);
        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation result = null;
        for (SupportFragmentObserver observer : mObservers) {
            if (result != null) {
                observer.onCreateAnimation(this, transit, enter, nextAnim);
            } else {
                result = observer.onCreateAnimation(this, transit, enter, nextAnim);
            }
        }

        if (result != null) {
            super.onCreateAnimation(transit, enter, nextAnim);
        } else {
            result = super.onCreateAnimation(transit, enter, nextAnim);
        }

        return result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onCreate(this, savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = null;
        for (SupportFragmentObserver observer : mObservers) {
            if (result != null) {
                observer.onCreateView(this, inflater, container, savedInstanceState);
            } else {
                result = observer.onCreateView(this, inflater, container, savedInstanceState);
            }
        }

        if (result != null) {
            super.onCreateView(inflater, container, savedInstanceState);
        } else {
            result = super.onCreateView(inflater, container, savedInstanceState);
        }

        return result;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onViewCreated(this, view, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onActivityCreated(this, savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onViewStateRestored(this, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onStart(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onResume(this);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onSaveInstanceState(this, outState);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onConfigurationChanged(this, newConfig);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onPause(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onStop(this);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onLowMemory(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onDestroyView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onDestroy(this);
        }

        mObservers.clear();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onDetach(this);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onCreateOptionsMenu(this, menu, inflater);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onPrepareOptionsMenu(this, menu);
        }
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();

        for (SupportFragmentObserver observer : mObservers) {
            observer.onDestroyOptionsMenu(this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        for (SupportFragmentObserver observer : mObservers) {
            if (result) {
                observer.onOptionsItemSelected(this, item);
            } else {
                result = observer.onOptionsItemSelected(this, item);
            }
        }

        if (result) {
            super.onOptionsItemSelected(item);
        } else {
            result = super.onOptionsItemSelected(item);
        }

        return result;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onOptionsMenuClosed(this, menu);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        for (SupportFragmentObserver observer : mObservers) {
            observer.onCreateContextMenu(this, menu, view, menuInfo);
        }
    }
}

