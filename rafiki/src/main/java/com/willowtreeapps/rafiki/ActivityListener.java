package com.willowtreeapps.rafiki;

import android.app.Activity;
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

/**
 * Created by charlie on 12/3/14.
 */
public interface ActivityListener {
    public void onCreate(Activity Activity, Bundle savedInstanceState);

    public void onActivityResult(Activity fragmentActivity, int requestCode, int resultCode, Intent data);

    /**
     * This method differs slightly from the normal Activity. If you return false from this activity
     * then the calling activity will not call super.onBackPress()
     *
     * @param Activity
     * @return true if you want to block the call to super.onBackPress(), false otherwise
     */
    public boolean onBackPressed(Activity Activity);

    public void onConfigurationChanged(Activity Activity, Configuration newConfig);

    /**
     * This method is similar to the normal activity. Return true if you want to panel to be shown.
     * Returning false is not guarunteed to hide the panel however because another observer may have returned true
     *
     * @param Activity
     * @param featureId
     * @param menu
     * @return return true to show the panel, by default you should return false
     */
    public boolean onCreatePanelMenu(Activity Activity, int featureId, Menu menu);

    /**
     * Return a view if you want to react to this onCreateView. HOWEVER, if you return a view you have to be the first observable to do so
     * Otherwise the result is ignored
     *
     * @param Activity
     * @param name
     * @param context
     * @param attrs
     * @return A view if it is desired, null otherwise
     */
    public View onCreateView(Activity Activity, String name, Context context, AttributeSet attrs);

    /**
     * The onDestroy event from an activity. After this call this observable will no longer receive events from the activity
     *
     * @param Activity
     */
    public void onDestroy(Activity Activity);

    public void onLowMemory(Activity Activity);

    public void onPause(Activity Activity);

    public void onResume(Activity Activity);

    public void onSaveInstanceState(Activity Activity, Bundle outState);

    public boolean onCreateOptionsMenu(Activity activity, Menu menu);

    public boolean onOptionsItemSelected(Activity activity, MenuItem item);

    public boolean onKeyDown(Activity Activity, int keyCode, KeyEvent event);

    public boolean onMenuItemSelected(Activity Activity, int featureId, MenuItem item);

    public void onPanelClosed(Activity Activity, int featureId, Menu menu);

    public void onNewIntent(Activity Activity, Intent intent);

    public void onPostResume(Activity Activity);

    public void onResumeFragments(Activity Activity);

    public boolean onPreparePanel(Activity Activity, int featureId, View view, Menu menu);

    public boolean onPrepareOptionsPanel(Activity Activity, View view, Menu menu);

    public void onStart(Activity Activity);

    public void onStop(Activity Activity);

    /**
     * A method to save a custom object. If you implement this method you most also implement getStaticID.
     * @see ActivityListener#getStaticID
     *
     * @return An object for the activity to hold onto
     */
    public Object onRetainCustomNonConfigurationInstance(Activity Activity);

    public void onAttachFragment(Activity Activity, Fragment fragment);

    public void onCreate(Activity Activity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestoreInstanceState(Activity Activity, Bundle savedInstanceState);

    public void onRestoreInstanceState(Activity Activity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onPostCreate(Activity Activity, Bundle savedInstanceState);

    public void onPostCreate(Activity Activity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestart(Activity Activity);

    public void onSaveInstanceState(Activity Activity, Bundle outState, PersistableBundle outPersistentState);

    public void onUserLeaveHint(Activity Activity);

    public boolean onCreateThumbnail(Activity Activity, Bitmap outBitmap, Canvas canvas);

    /**
     * A method to set the activities description. Note that since only one description can be saved, only one description per activity should
     * handle this callback with a non-null value. If multiple observers return an object an IllegalStateException will be thrown
     *
     * @return A description for the activity or null. Default null
     */
    public CharSequence onCreateDescription(Activity Activity);

    public void onProvideAssistData(Activity Activity, Bundle data);

    public void onTrimMemory(Activity Activity, int level);

    public void onAttachFragment(Activity Activity, android.app.Fragment fragment);

    public boolean onKeyLongPress(Activity Activity, int keyCode, KeyEvent event);

    public boolean onKeyUp(Activity Activity, int keyCode, KeyEvent event);

    public boolean onKeyMultiple(Activity Activity, int keyCode, int repeatCount, KeyEvent event);

    public boolean onKeyShortcut(Activity Activity, int keyCode, KeyEvent event);

    public boolean onTouchEvent(Activity Activity, MotionEvent event);

    public boolean onTrackballEvent(Activity Activity, MotionEvent event);

    public boolean onGenericMotionEvent(Activity Activity, MotionEvent event);

    public void onUserInteraction(Activity Activity);

    public void onWindowAttributesChanged(Activity Activity, WindowManager.LayoutParams params);

    public void onContentChanged(Activity Activity);

    public void onWindowFocusChanged(Activity Activity, boolean hasFocus);

    public void onAttachedToWindow(Activity Activity);

    public void onDetachedFromWindow(Activity Activity);

    public View onCreatePanelView(Activity Activity, int featureId);

    public boolean onMenuOpened(Activity Activity, int featureId, Menu menu);

    public boolean onPrepareOptionsMenu(Activity Activity, Menu menu);

    public boolean onNavigateUp(Activity Activity);

    public boolean onNavigateUpFromChild(Activity Activity, Activity child);

    public void onCreateNavigateUpTaskStack(Activity Activity, TaskStackBuilder builder);

    public void onPrepareNavigateUpTaskStack(Activity Activity, TaskStackBuilder builder);

    public void onOptionsMenuClosed(Activity Activity, Menu menu);

    public void onCreateContextMenu(Activity Activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    public boolean onContextItemSelected(Activity Activity, MenuItem item);

    public void onContextMenuClosed(Activity Activity, Menu menu);

    @Deprecated
    public Dialog onCreateDialog(Activity Activity, int id);

    @Deprecated
    public Dialog onCreateDialog(Activity Activity, int id, Bundle args);

    @Deprecated
    public void onPrepareDialog(Activity Activity, int id, Dialog dialog);

    @Deprecated
    public void onPrepareDialog(Activity Activity, int id, Dialog dialog, Bundle args);

    public boolean onSearchRequested(Activity Activity);

    public void onApplyThemeResource(Activity Activity, Resources.Theme theme, int resid, boolean first);

    public void onActivityReenter(Activity Activity, int resultCode, Intent data);

    public void onTitleChanged(Activity Activity, CharSequence title, int color);

    public void onChildTitleChanged(Activity Activity, Activity childActivity, CharSequence title);

    public View onCreateView(Activity Activity, View parent, String name, Context context, AttributeSet attrs);

    public void onVisibleBehindCanceled(Activity Activity);

    public void onEnterAnimationComplete(Activity Activity);

    public ActionMode onWindowStartingActionMode(Activity Activity, ActionMode.Callback callback);

    public void onActionModeStarted(Activity observableActionBarActivity, ActionMode mode);

    public void onActionModeFinished(Activity observableActionBarActivity, ActionMode mode);

    public void onSupportActionModeStarted(DispatchActionBarActivity observableActionBarActivity, android.support.v7.view.ActionMode mode);

    public void onSupportActionModeFinished(DispatchActionBarActivity observableActionBarActivity, android.support.v7.view.ActionMode mode);

    public void onCreateSupportNavigateUpTaskStack(DispatchActionBarActivity observableActionBarActivity, android.support.v4.app.TaskStackBuilder builder);

    public void onPrepareSupportNavigateUpTaskStack(DispatchActionBarActivity observableActionBarActivity, android.support.v4.app.TaskStackBuilder builder);

    public boolean onSupportNavigateUp(DispatchActionBarActivity observableActionBarActivity);

    public void onSupportContentChanged(DispatchActionBarActivity observableActionBarActivity);

    /**
     * Override this to provide a static ID so that onRetainCustomNonConfigurationInstance can map your object back to you
     *
     * @return A unique unchanging ID for this observable. A fully qualified class name is recommended
     */
    public String getStaticID();
}
