package com.willowtreeapps.androidobservables;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.lang.ref.WeakReference;

/**
 * Created by charlie on 12/3/14.
 */
public class ActivityObserverImpl implements ActivityObserver{

    WeakReference<Activity> mActivity = null;

    /**
     * A method to get the activity we're monitoring. This activity will be stored after onCreate
     *  however this method can return null if the activity is destroyed
     * @return The observing activity or null if it has been destroyed
     */
    public Activity getActivity() {
        if(mActivity == null) return null;

        return mActivity.get();
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        mActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityResult(Activity fragmentActivity, int requestCode, int resultCode, Intent data) {

    }

    @Override
    public boolean onBackPressed(Activity activity) {
        return false;
    }

    @Override
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {

    }

    @Override
    public boolean onCreatePanelMenu(Activity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public View onCreateView(Activity activity, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onDestroy(Activity activity) {

    }

    @Override
    public void onLowMemory(Activity activity) {

    }

    @Override
    public void onPause(Activity activity) {

    }

    @Override
    public void onResume(Activity activity) {

    }

    @Override
    public void onSaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onKeyDown(Activity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuItemSelected(Activity activity, int featureId, MenuItem item) {
        return false;
    }

    @Override
    public void onPanelClosed(Activity activity, int featureId, Menu menu) {

    }

    @Override
    public void onNewIntent(Activity activity, Intent intent) {

    }

    @Override
    public void onPostResume(Activity activity) {

    }

    @Override
    public void onResumeFragments(Activity activity) {

    }

    @Override
    public boolean onPreparePanel(Activity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsPanel(Activity activity, View view, Menu menu) {
        return false;
    }

    @Override
    public void onStart(Activity activity) {

    }

    @Override
    public void onStop(Activity activity) {

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(Activity activity) {
        return null;
    }

    @Override
    public void onAttachFragment(Activity activity, Fragment fragment) {

    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onPostCreate(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onPostCreate(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onRestart(Activity activity) {

    }

    @Override
    public void onSaveInstanceState(Activity activity, Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public void onUserLeaveHint(Activity activity) {

    }

    @Override
    public boolean onCreateThumbnail(Activity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public CharSequence onCreateDescription(Activity activity) {
        return null;
    }

    @Override
    public void onProvideAssistData(Activity activity, Bundle data) {

    }

    @Override
    public void onTrimMemory(Activity activity, int level) {

    }

    @Override
    public void onAttachFragment(Activity activity, android.app.Fragment fragment) {

    }

    @Override
    public boolean onKeyLongPress(Activity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(Activity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(Activity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(Activity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(Activity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(Activity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(Activity activity, MotionEvent event) {
        return false;
    }

    @Override
    public void onUserInteraction(Activity activity) {

    }

    @Override
    public void onWindowAttributesChanged(Activity activity, WindowManager.LayoutParams params) {

    }

    @Override
    public void onContentChanged(Activity activity) {

    }

    @Override
    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {

    }

    @Override
    public void onAttachedToWindow(Activity activity) {

    }

    @Override
    public void onDetachedFromWindow(Activity activity) {

    }

    @Override
    public View onCreatePanelView(Activity activity, int featureId) {
        return null;
    }

    @Override
    public boolean onMenuOpened(Activity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(Activity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(Activity activity, Activity child) {
        return false;
    }

    @Override
    public void onCreateNavigateUpTaskStack(Activity activity, TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareNavigateUpTaskStack(Activity activity, TaskStackBuilder builder) {

    }

    @Override
    public void onOptionsMenuClosed(Activity activity, Menu menu) {

    }

    @Override
    public void onCreateContextMenu(Activity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

    @Override
    public boolean onContextItemSelected(Activity activity, MenuItem item) {
        return false;
    }

    @Override
    public void onContextMenuClosed(Activity activity, Menu menu) {

    }

    @Override
    public Dialog onCreateDialog(Activity activity, int id) {
        return null;
    }

    @Override
    public Dialog onCreateDialog(Activity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onPrepareDialog(Activity activity, int id, Dialog dialog) {

    }

    @Override
    public void onPrepareDialog(Activity activity, int id, Dialog dialog, Bundle args) {

    }

    @Override
    public boolean onSearchRequested(Activity activity) {
        return false;
    }

    @Override
    public void onApplyThemeResource(Activity activity, Resources.Theme theme, int resid, boolean first) {

    }

    @Override
    public void onActivityReenter(Activity activity, int resultCode, Intent data) {

    }

    @Override
    public void onTitleChanged(Activity activity, CharSequence title, int color) {

    }

    @Override
    public void onChildTitleChanged(Activity activity, Activity childActivity, CharSequence title) {

    }

    @Override
    public View onCreateView(Activity activity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onVisibleBehindCanceled(Activity activity) {

    }

    @Override
    public void onEnterAnimationComplete(Activity activity) {

    }

    @Override
    public ActionMode onWindowStartingActionMode(Activity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public void onActionModeStarted(Activity observableActionBarActivity, ActionMode mode) {

    }

    @Override
    public void onActionModeFinished(Activity observableActionBarActivity, ActionMode mode) {

    }

    @Override
    public void onSupportActionModeStarted(ObservableActionBarActivity observableActionBarActivity, android.support.v7.view.ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(ObservableActionBarActivity observableActionBarActivity, android.support.v7.view.ActionMode mode) {

    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(ObservableActionBarActivity observableActionBarActivity, android.support.v4.app.TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(ObservableActionBarActivity observableActionBarActivity, android.support.v4.app.TaskStackBuilder builder) {

    }

    @Override
    public boolean onSupportNavigateUp(ObservableActionBarActivity observableActionBarActivity) {
        return false;
    }

    @Override
    public void onSupportContentChanged(ObservableActionBarActivity observableActionBarActivity) {

    }
}
