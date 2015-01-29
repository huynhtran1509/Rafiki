package com.willowtreeapps.rafiki;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by charlie on 12/19/14.
 */
public interface FragmentListener {
    public boolean onContextItemSelected(Fragment fragment, MenuItem item);

    public void onHiddenChanged(Fragment fragment, boolean hidden);

    public void onInflate(Fragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    public void onAttach(Fragment fragment, Activity activity);

    public Animator onCreateAnimation(Fragment fragment, int transit, boolean enter, int nextAnim);

    public void onCreate(Fragment fragment, Bundle savedInstanceState);

    public View onCreateView(Fragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public void onViewCreated(Fragment fragment, View view, Bundle savedInstanceState);

    public void onActivityCreated(Fragment fragment, Bundle savedInstanceState);

    public void onViewStateRestored(Fragment fragment, Bundle savedInstanceState);

    public void onStart(Fragment fragment);

    public void onResume(Fragment fragment);

    public void onSaveInstanceState(Fragment fragment, Bundle outState);

    public void onConfigurationChanged(Fragment fragment, Configuration newConfig);

    public void onPause(Fragment fragment);

    public void onStop(Fragment fragment);

    public void onLowMemory(Fragment fragment);

    public void onDestroyView(Fragment fragment);

    public void onDestroy(Fragment fragment);

    public void onDetach(Fragment fragment);

    public void onCreateOptionsMenu(Fragment fragment, Menu menu, MenuInflater inflater);

    public void onPrepareOptionsMenu(Fragment fragment, Menu menu);

    public void onDestroyOptionsMenu(Fragment fragment);

    public boolean onOptionsItemSelected(Fragment fragment, MenuItem item);

    public void onOptionsMenuClosed(Fragment fragment, Menu menu);

    public void onCreateContextMenu(Fragment fragment, ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo);
}
