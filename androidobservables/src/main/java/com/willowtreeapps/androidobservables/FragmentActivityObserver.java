package com.willowtreeapps.androidobservables;

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
public interface FragmentActivityObserver {
    public void onCreate(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState);
    public void onActivityResult(ObservableFragmentActivity fragmentActivity, int requestCode, int resultCode, Intent data);

    /**
     * This method differs slightly from the normal Activity. If you return false from this activity
     *  then the calling activity will not call super.onBackPress()
     * @param observableFragmentActivity
     * @return true if you want to block the call to super.onBackPress(), false otherwise
     */
    public boolean onBackPressed(ObservableFragmentActivity observableFragmentActivity);

    public void onConfigurationChanged(ObservableFragmentActivity observableFragmentActivity, Configuration newConfig);

    /**
     * This method is similar to the normal activity. Return true if you want to panel to be shown.
     *  Returning false is not guarunteed to hide the panel however because another observer may have returned true
     * @param observableFragmentActivity
     * @param featureId
     * @param menu
     * @return return true to show the panel, by default you should return false
     */
    public boolean onCreatePanelMenu(ObservableFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    /**
     * Return a view if you want to react to this onCreateView. HOWEVER, if you return a view you have to be the first observable to do so
     *  Otherwise the result is ignored
     * @param observableFragmentActivity
     * @param name
     * @param context
     * @param attrs
     * @return A view if it is desired, null otherwise
     */
    public View onCreateView(ObservableFragmentActivity observableFragmentActivity, String name, Context context, AttributeSet attrs);

    /**
     * The onDestroy event from an activity. After this call this observable will no longer receive events from the activity
     * @param observableFragmentActivity
     */
    public void onDestroy(ObservableFragmentActivity observableFragmentActivity);

    public void onLowMemory(ObservableFragmentActivity observableFragmentActivity);

    public void onPause(ObservableFragmentActivity observableFragmentActivity);

    public void onResume(ObservableFragmentActivity observableFragmentActivity);

    public void onSaveInstanceState(ObservableFragmentActivity observableFragmentActivity, Bundle outState);

    public boolean onCreateOptionsMenu(ObservableFragmentActivity activity, Menu menu);

    public boolean onOptionsItemSelected(ObservableFragmentActivity activity, MenuItem item);

    public boolean onKeyDown(ObservableFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onMenuItemSelected(ObservableFragmentActivity observableFragmentActivity, int featureId, MenuItem item);

    public void onPanelClosed(ObservableFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    public void onNewIntent(ObservableFragmentActivity observableFragmentActivity, Intent intent);

    public void onPostResume(ObservableFragmentActivity observableFragmentActivity);

    public void onResumeFragments(ObservableFragmentActivity observableFragmentActivity);

    public boolean onPreparePanel(ObservableFragmentActivity observableFragmentActivity, int featureId, View view, Menu menu);

    public boolean onPrepareOptionsPanel(ObservableFragmentActivity observableFragmentActivity, View view, Menu menu);

    public void onStart(ObservableFragmentActivity observableFragmentActivity);

    public void onStop(ObservableFragmentActivity observableFragmentActivity);

    /**
     * A method to save a custom object. Note that since only one object can be saved, only one object per activity should
     *  handle this callback with a non-null value. If multiple observers return an object an IllegalStateException will be thrown
     * @return An object for the activity to hold onto
     */
    public Object onRetainCustomNonConfigurationInstance(ObservableFragmentActivity observableFragmentActivity);

    public void onAttachFragment(ObservableFragmentActivity observableFragmentActivity, Fragment fragment);

    public void onCreate(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestoreInstanceState(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState);

    public void onRestoreInstanceState(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onPostCreate(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState);

    public void onPostCreate(ObservableFragmentActivity observableFragmentActivity, Bundle savedInstanceState, PersistableBundle persistentState);

    public void onRestart(ObservableFragmentActivity observableFragmentActivity);

    public void onSaveInstanceState(ObservableFragmentActivity observableFragmentActivity, Bundle outState, PersistableBundle outPersistentState);

    public void onUserLeaveHint(ObservableFragmentActivity observableFragmentActivity);

    public boolean onCreateThumbnail(ObservableFragmentActivity observableFragmentActivity, Bitmap outBitmap, Canvas canvas);

    /**
     * A method to set the activities description. Note that since only one description can be saved, only one description per activity should
     *  handle this callback with a non-null value. If multiple observers return an object an IllegalStateException will be thrown
     * @return A description for the activity or null. Default null
     */
    public CharSequence onCreateDescription(ObservableFragmentActivity observableFragmentActivity);

    public void onProvideAssistData(ObservableFragmentActivity observableFragmentActivity, Bundle data);

    public void onTrimMemory(ObservableFragmentActivity observableFragmentActivity, int level);

    public void onAttachFragment(ObservableFragmentActivity observableFragmentActivity, android.app.Fragment fragment);

    public boolean onKeyLongPress(ObservableFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onKeyUp(ObservableFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onKeyMultiple(ObservableFragmentActivity observableFragmentActivity, int keyCode, int repeatCount, KeyEvent event);

    public boolean onKeyShortcut(ObservableFragmentActivity observableFragmentActivity, int keyCode, KeyEvent event);

    public boolean onTouchEvent(ObservableFragmentActivity observableFragmentActivity, MotionEvent event);

    public boolean onTrackballEvent(ObservableFragmentActivity observableFragmentActivity, MotionEvent event);

    public boolean onGenericMotionEvent(ObservableFragmentActivity observableFragmentActivity, MotionEvent event);

    public void onUserInteraction(ObservableFragmentActivity observableFragmentActivity);

    public void onWindowAttributesChanged(ObservableFragmentActivity observableFragmentActivity, WindowManager.LayoutParams params);

    public void onContentChanged(ObservableFragmentActivity observableFragmentActivity);

    public void onWindowFocusChanged(ObservableFragmentActivity observableFragmentActivity, boolean hasFocus);

    public void onAttachedToWindow(ObservableFragmentActivity observableFragmentActivity);

    public void onDetachedFromWindow(ObservableFragmentActivity observableFragmentActivity);

    public View onCreatePanelView(ObservableFragmentActivity observableFragmentActivity, int featureId);

    public boolean onMenuOpened(ObservableFragmentActivity observableFragmentActivity, int featureId, Menu menu);

    public boolean onPrepareOptionsMenu(ObservableFragmentActivity observableFragmentActivity, Menu menu);

    public boolean onNavigateUp(ObservableFragmentActivity observableFragmentActivity);

    public boolean onNavigateUpFromChild(ObservableFragmentActivity observableFragmentActivity, Activity child);

    public void onCreateNavigateUpTaskStack(ObservableFragmentActivity observableFragmentActivity, TaskStackBuilder builder);

    public void onPrepareNavigateUpTaskStack(ObservableFragmentActivity observableFragmentActivity, TaskStackBuilder builder);

    public void onOptionsMenuClosed(ObservableFragmentActivity observableFragmentActivity, Menu menu);

    public void onCreateContextMenu(ObservableFragmentActivity observableFragmentActivity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    public boolean onContextItemSelected(ObservableFragmentActivity observableFragmentActivity, MenuItem item);

    public void onContextMenuClosed(ObservableFragmentActivity observableFragmentActivity, Menu menu);

    @Deprecated
    public Dialog onCreateDialog(ObservableFragmentActivity observableFragmentActivity, int id);

    @Deprecated
    public Dialog onCreateDialog(ObservableFragmentActivity observableFragmentActivity, int id, Bundle args);

    @Deprecated
    public void onPrepareDialog(ObservableFragmentActivity observableFragmentActivity, int id, Dialog dialog);

    @Deprecated
    public void onPrepareDialog(ObservableFragmentActivity observableFragmentActivity, int id, Dialog dialog, Bundle args);

    public boolean onSearchRequested(ObservableFragmentActivity observableFragmentActivity);

    public void onApplyThemeResource(ObservableFragmentActivity observableFragmentActivity, Resources.Theme theme, int resid, boolean first);

    public void onActivityReenter(ObservableFragmentActivity observableFragmentActivity, int resultCode, Intent data);

    public void onTitleChanged(ObservableFragmentActivity observableFragmentActivity, CharSequence title, int color);

    public void onChildTitleChanged(ObservableFragmentActivity observableFragmentActivity, Activity childActivity, CharSequence title);

    public View onCreateView(ObservableFragmentActivity observableFragmentActivity, View parent, String name, Context context, AttributeSet attrs);

    public void onVisibleBehindCanceled(ObservableFragmentActivity observableFragmentActivity);

    public void onEnterAnimationComplete(ObservableFragmentActivity observableFragmentActivity);

    public ActionMode onWindowStartingActionMode(ObservableFragmentActivity observableFragmentActivity, ActionMode.Callback callback);

    public void onActionModeStarted(ObservableFragmentActivity observableFragmentActivity);

    public void onActionModeFinished(ObservableFragmentActivity observableFragmentActivity);
}
