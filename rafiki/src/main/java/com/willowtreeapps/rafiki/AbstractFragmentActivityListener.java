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
public interface AbstractFragmentActivityListener {
    public void onCreate(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState);
    public void onActivityResult(DispatchFragmentActivity fragmentActivity, int requestCode, int resultCode, Intent data);

    /**
     * This method differs slightly from the normal Activity. If you return false from this activity
     *  then the calling activity will not call super.onBackPress()
     * @param observableFragmentActivity
     * @return true if you want to block the call to super.onBackPress(), false otherwise
     */
    public boolean onBackPressed(DispatchFragmentActivity observableFragmentActivity);

    public void onConfigurationChanged(DispatchFragmentActivity observableFragmentActivity, Configuration newConfig);

    /**
     * This method is similar to the normal activity. Return true if you want to panel to be shown.
     *  Returning false is not guarunteed to hide the panel however because another observer may have returned true
     * @param observableFragmentActivity
     * @param featureId
     * @param menu
     * @return return true to show the panel, by default you should return false
     */
    public boolean onCreatePanelMenu(DispatchFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    /**
     * Return a view if you want to react to this onCreateView. HOWEVER, if you return a view you have to be the first observable to do so
     *  Otherwise the result is ignored
     * @param observableFragmentActivity
     * @param name
     * @param context
     * @param attrs
     * @return A view if it is desired, null otherwise
     */
    public View onCreateView(DispatchFragmentActivity observableFragmentActivity, String name, Context context, AttributeSet attrs);

    /**
     * The onDestroy event from an activity. After this call this observable will no longer receive events from the activity
     * @param observableFragmentActivity
     */
    public void onDestroy(DispatchFragmentActivity observableFragmentActivity);

    public void onLowMemory(DispatchFragmentActivity observableFragmentActivity);

    public void onPause(DispatchFragmentActivity observableFragmentActivity);

    public void onResume(DispatchFragmentActivity observableFragmentActivity);

    public void onSaveInstanceState(DispatchFragmentActivity observableFragmentActivity, Bundle outState);

    public boolean onCreateOptionsMenu(DispatchFragmentActivity activity, Menu menu);

    public boolean onOptionsItemSelected(DispatchFragmentActivity activity, MenuItem item);

    public boolean onKeyDown(DispatchFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onMenuItemSelected(DispatchFragmentActivity observableFragmentActivity, int featureId, MenuItem item);

    public void onPanelClosed(DispatchFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    public void onNewIntent(DispatchFragmentActivity observableFragmentActivity, Intent intent);

    public void onPostResume(DispatchFragmentActivity observableFragmentActivity);

    public void onResumeFragments(DispatchFragmentActivity observableFragmentActivity);

    public boolean onPreparePanel(DispatchFragmentActivity observableFragmentActivity, int featureId, View view, Menu menu);

    public boolean onPrepareOptionsPanel(DispatchFragmentActivity observableFragmentActivity, View view, Menu menu);

    public void onStart(DispatchFragmentActivity observableFragmentActivity);

    public void onStop(DispatchFragmentActivity observableFragmentActivity);

    /**
     * A method to save a custom object. Note that since only one object can be saved, only one object per activity should
     *  handle this callback with a non-null value. If multiple observers return an object an IllegalStateException will be thrown
     * @return An object for the activity to hold onto
     */
    public Object onRetainCustomNonConfigurationInstance(DispatchFragmentActivity observableFragmentActivity);

    public void onAttachFragment(DispatchFragmentActivity observableFragmentActivity, Fragment fragment);

    public void onCreate(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestoreInstanceState(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState);

    public void onRestoreInstanceState(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onPostCreate(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState);

    public void onPostCreate(DispatchFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestart(DispatchFragmentActivity observableFragmentActivity);

    public void onSaveInstanceState(DispatchFragmentActivity observableFragmentActivity, Bundle outState, PersistableBundle outPersistentState);

    public void onUserLeaveHint(DispatchFragmentActivity observableFragmentActivity);

    public boolean onCreateThumbnail(DispatchFragmentActivity observableFragmentActivity, Bitmap outBitmap, Canvas canvas);

    /**
     * A method to set the activities description. Note that since only one description can be saved, only one description per activity should
     *  handle this callback with a non-null value. If multiple observers return an object an IllegalStateException will be thrown
     * @return A description for the activity or null. Default null
     */
    public CharSequence onCreateDescription(DispatchFragmentActivity observableFragmentActivity);

    public void onProvideAssistData(DispatchFragmentActivity observableFragmentActivity, Bundle data);

    public void onTrimMemory(DispatchFragmentActivity observableFragmentActivity, int level);

    public void onAttachFragment(DispatchFragmentActivity observableFragmentActivity, android.app.Fragment fragment);

    public boolean onKeyLongPress(DispatchFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onKeyUp(DispatchFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onKeyMultiple(DispatchFragmentActivity observableFragmentActivity, int keyCode, int repeatCount, KeyEvent event);

    public boolean onKeyShortcut(DispatchFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onTouchEvent(DispatchFragmentActivity observableFragmentActivity, MotionEvent event);

    public boolean onTrackballEvent(DispatchFragmentActivity observableFragmentActivity, MotionEvent event);

    public boolean onGenericMotionEvent(DispatchFragmentActivity observableFragmentActivity, MotionEvent event);

    public void onUserInteraction(DispatchFragmentActivity observableFragmentActivity);

    public void onWindowAttributesChanged(DispatchFragmentActivity observableFragmentActivity, WindowManager.LayoutParams params);

    public void onContentChanged(DispatchFragmentActivity observableFragmentActivity);

    public void onWindowFocusChanged(DispatchFragmentActivity observableFragmentActivity, boolean hasFocus);

    public void onAttachedToWindow(DispatchFragmentActivity observableFragmentActivity);

    public void onDetachedFromWindow(DispatchFragmentActivity observableFragmentActivity);

    public View onCreatePanelView(DispatchFragmentActivity observableFragmentActivity, int featureId);

    public boolean onMenuOpened(DispatchFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    public boolean onPrepareOptionsMenu(DispatchFragmentActivity observableFragmentActivity, Menu menu);

    public boolean onNavigateUp(DispatchFragmentActivity observableFragmentActivity);

    public boolean onNavigateUpFromChild(DispatchFragmentActivity observableFragmentActivity, Activity child);

    public void onCreateNavigateUpTaskStack(DispatchFragmentActivity observableFragmentActivity, TaskStackBuilder builder);

    public void onPrepareNavigateUpTaskStack(DispatchFragmentActivity observableFragmentActivity, TaskStackBuilder builder);

    public void onOptionsMenuClosed(DispatchFragmentActivity observableFragmentActivity, Menu menu);

    public void onCreateContextMenu(DispatchFragmentActivity observableFragmentActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    public boolean onContextItemSelected(DispatchFragmentActivity observableFragmentActivity, MenuItem item);

    public void onContextMenuClosed(DispatchFragmentActivity observableFragmentActivity, Menu menu);

    @Deprecated
    public Dialog onCreateDialog(DispatchFragmentActivity observableFragmentActivity, int id);

    @Deprecated
    public Dialog onCreateDialog(DispatchFragmentActivity observableFragmentActivity, int id, Bundle args);

    @Deprecated
    public void onPrepareDialog(DispatchFragmentActivity observableFragmentActivity, int id, Dialog dialog);

    @Deprecated
    public void onPrepareDialog(DispatchFragmentActivity observableFragmentActivity, int id, Dialog dialog, Bundle args);

    public boolean onSearchRequested(DispatchFragmentActivity observableFragmentActivity);

    public void onApplyThemeResource(DispatchFragmentActivity observableFragmentActivity, Resources.Theme theme, int resid, boolean first);

    public void onActivityReenter(DispatchFragmentActivity observableFragmentActivity, int resultCode, Intent data);

    public void onTitleChanged(DispatchFragmentActivity observableFragmentActivity, CharSequence title, int color);

    public void onChildTitleChanged(DispatchFragmentActivity observableFragmentActivity, Activity childActivity, CharSequence title);

    public View onCreateView(DispatchFragmentActivity observableFragmentActivity, View parent, String name, Context context, AttributeSet attrs);

    public void onVisibleBehindCanceled(DispatchFragmentActivity observableFragmentActivity);

    public void onEnterAnimationComplete(DispatchFragmentActivity observableFragmentActivity);

    public ActionMode onWindowStartingActionMode(DispatchFragmentActivity observableFragmentActivity, ActionMode.Callback callback);

    public void onActionModeStarted(DispatchFragmentActivity observableFragmentActivity);

    public void onActionModeFinished(DispatchFragmentActivity observableFragmentActivity);
}
