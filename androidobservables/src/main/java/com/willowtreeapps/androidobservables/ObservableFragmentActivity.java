package com.willowtreeapps.androidobservables;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlie on 12/3/14.
 */
public abstract class ObservableFragmentActivity extends FragmentActivity {

    private ArrayList<ActivityObserver> mObservers = new ArrayList<ActivityObserver>();
    private boolean mIsPaused = true;

    public void addObserver(ActivityObserver observer) {
        mObservers.add(observer);
    }

    public void removeObserver(ActivityObserver observer) {
        mObservers.remove(observer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (ActivityObserver observer : mObservers) {
            observer.onCreate(this, savedInstanceState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (ActivityObserver observer : mObservers) {
            observer.onActivityResult(this, requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        boolean blockSuper = false;
        for (ActivityObserver observer : mObservers) {

            //We only need to know if one observable does not want to allow the back press
            if (blockSuper) {
                observer.onBackPressed(this);
            } else {
                blockSuper = observer.onBackPressed(this);
            }
        }
        if (!blockSuper)
            super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        for (ActivityObserver observer : mObservers) {
            observer.onConfigurationChanged(this, newConfig);
        }
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        boolean showPanel = false;
        for (ActivityObserver observer : mObservers) {
            if (showPanel) {
                observer.onCreatePanelMenu(this, featureId, menu);
            } else {
                showPanel = observer.onCreatePanelMenu(this, featureId, menu);
            }
        }

        if (showPanel) {
            super.onCreatePanelMenu(featureId, menu);
        } else {
            showPanel = super.onCreatePanelMenu(featureId, menu);
        }

        return showPanel;
    }

    @Override
    public View onCreateView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View result = null;
        for (ActivityObserver observer : mObservers) {
            if (result != null) {
                observer.onCreateView(this, name, context, attrs);
            } else {
                result = observer.onCreateView(this, name, context, attrs);
            }
        }
        if (result != null) {
            super.onCreateView(name, context, attrs);
        } else {
            result = super.onCreateView(name, context, attrs);
        }
        return result;
    }

    @Override
    protected void onDestroy() {
        for (ActivityObserver observer : mObservers) {
            observer.onDestroy(this);
        }

        //Since we're destroying, clear out the observers
        mObservers.clear();

        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        for (ActivityObserver observer : mObservers) {
            observer.onLowMemory(this);
        }
    }

    @Override
    protected void onPause() {
        //Even though observers should know that it's paused because we're entering the onPaused, lets set this first
        mIsPaused = true;
        super.onPause();

        for (ActivityObserver observer : mObservers) {
            observer.onPause(this);
        }
    }

    @Override
    protected void onResume() {
        //Even though observers should know that it's resuming because we're entering the onPaused, lets set this first
        mIsPaused = false;
        super.onResume();

        for (ActivityObserver observer : mObservers) {
            observer.onResume(this);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        for (ActivityObserver observer : mObservers) {
            observer.onSaveInstanceState(this, outState);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean showMenu = false;
        for (ActivityObserver observer : mObservers) {
            if (showMenu) {
                observer.onCreateOptionsMenu(this, menu);
            } else {
                showMenu = observer.onCreateOptionsMenu(this, menu);
            }
        }

        if (showMenu) {
            super.onCreateOptionsMenu(menu);
        } else {
            showMenu = super.onCreateOptionsMenu(menu);
        }

        return showMenu;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onKeyDown(this, keyCode, event);
            } else {
                result = observer.onKeyDown(this, keyCode, event);
            }
        }

        if (result) {
            super.onKeyDown(keyCode, event);
        } else {
            result = super.onKeyDown(keyCode, event);
        }

        return result;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onMenuItemSelected(this, featureId, item);
            } else {
                result = observer.onMenuItemSelected(this, featureId, item);
            }
        }

        if (result) {
            super.onMenuItemSelected(featureId, item);
        } else {
            result = super.onMenuItemSelected(featureId, item);
        }

        return result;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);

        for (ActivityObserver observer : mObservers) {
            observer.onPanelClosed(this, featureId, menu);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        for (ActivityObserver observer : mObservers) {
            observer.onNewIntent(this, intent);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        for (ActivityObserver observer : mObservers) {
            observer.onPostResume(this);
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();

        for (ActivityObserver observer : mObservers) {
            observer.onResumeFragments(this);
        }
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onPreparePanel(this, featureId, view, menu);
            } else {
                result = observer.onPreparePanel(this, featureId, view, menu);
            }
        }

        if (result) {
            super.onPreparePanel(featureId, view, menu);
        } else {
            result = super.onPreparePanel(featureId, view, menu);
        }

        return result;
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onPrepareOptionsPanel(this, view, menu);
            } else {
                result = observer.onPrepareOptionsPanel(this, view, menu);
            }
        }

        if (result) {
            super.onPrepareOptionsPanel(view, menu);
        } else {
            result = super.onPrepareOptionsPanel(view, menu);
        }

        return result;
    }

    @Override
    protected void onStart() {
        super.onStart();

        for (ActivityObserver observer : mObservers) {
            observer.onStart(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        for (ActivityObserver observer : mObservers) {
            observer.onStop(this);
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Object result = super.onRetainCustomNonConfigurationInstance();

        Object temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onRetainCustomNonConfigurationInstance(this);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple custom configuration instances cannot be saved");
                }
            }
        }

        return result;
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        for (ActivityObserver observer : mObservers) {
            observer.onAttachFragment(this, fragment);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        for (ActivityObserver observer : mObservers) {
            observer.onCreate(this, savedInstanceState, persistentState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for (ActivityObserver observer : mObservers) {
            observer.onRestoreInstanceState(this, savedInstanceState);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        for (ActivityObserver observer : mObservers) {
            observer.onRestoreInstanceState(this, savedInstanceState, persistentState);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        for (ActivityObserver observer : mObservers) {
            observer.onPostCreate(this, savedInstanceState);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        for (ActivityObserver observer : mObservers) {
            observer.onPostCreate(this, savedInstanceState, persistentState);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        for (ActivityObserver observer : mObservers) {
            observer.onRestart(this);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        for (ActivityObserver observer : mObservers) {
            observer.onSaveInstanceState(this, outState, outPersistentState);
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();

        for (ActivityObserver observer : mObservers) {
            observer.onUserLeaveHint(this);
        }
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onCreateThumbnail(this, outBitmap, canvas);
            } else {
                result = observer.onCreateThumbnail(this, outBitmap, canvas);
            }
        }

        if (result) {
            super.onCreateThumbnail(outBitmap, canvas);
        } else {
            result = super.onCreateThumbnail(outBitmap, canvas);
        }

        return result;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        CharSequence result = super.onCreateDescription();

        CharSequence temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onCreateDescription(this);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple custom configuration instances cannot be saved");
                }
            }
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);

        for (ActivityObserver observer : mObservers) {
            observer.onProvideAssistData(this, data);
        }
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        for (ActivityObserver observer : mObservers) {
            observer.onTrimMemory(this, level);
        };
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);

        for (ActivityObserver observer : mObservers) {
            observer.onAttachFragment(this, fragment);
        };
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onKeyLongPress(this, keyCode, event);
            } else {
                result = observer.onKeyLongPress(this, keyCode, event);
            }
        }

        if (result) {
            super.onKeyLongPress(keyCode, event);
        } else {
            result = super.onKeyLongPress(keyCode, event);
        }

        return result;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onKeyUp(this, keyCode, event);
            } else {
                result = observer.onKeyUp(this, keyCode, event);
            }
        }

        if (result) {
            super.onKeyUp(keyCode, event);
        } else {
            result = super.onKeyUp(keyCode, event);
        }

        return result;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onKeyMultiple(this, keyCode, repeatCount, event);
            } else {
                result = observer.onKeyMultiple(this, keyCode, repeatCount, event);
            }
        }

        if (result) {
            super.onKeyMultiple(keyCode, repeatCount, event);
        } else {
            result = super.onKeyMultiple(keyCode, repeatCount, event);
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onKeyShortcut(this, keyCode, event);
            } else {
                result = observer.onKeyShortcut(this, keyCode, event);
            }
        }

        if (result) {
            super.onKeyShortcut(keyCode, event);
        } else {
            result = super.onKeyShortcut(keyCode, event);
        }

        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onTouchEvent(this, event);
            } else {
                result = observer.onTouchEvent(this, event);
            }
        }

        if (result) {
            super.onTouchEvent(event);
        } else {
            result = super.onTouchEvent(event);
        }

        return result;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onTrackballEvent(this, event);
            } else {
                result = observer.onTrackballEvent(this, event);
            }
        }

        if (result) {
            super.onTrackballEvent(event);
        } else {
            result = super.onTrackballEvent(event);
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onGenericMotionEvent(this, event);
            } else {
                result = observer.onGenericMotionEvent(this, event);
            }
        }

        if (result) {
            super.onGenericMotionEvent(event);
        } else {
            result = super.onGenericMotionEvent(event);
        }

        return result;
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        for (ActivityObserver observer : mObservers) {
            observer.onUserInteraction(this);
        };
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);

        for (ActivityObserver observer : mObservers) {
            observer.onWindowAttributesChanged(this, params);
        };
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        for (ActivityObserver observer : mObservers) {
            observer.onContentChanged(this);
        };
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        for (ActivityObserver observer : mObservers) {
            observer.onWindowFocusChanged(this, hasFocus);
        };
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        for (ActivityObserver observer : mObservers) {
            observer.onAttachedToWindow(this);
        };
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        for (ActivityObserver observer : mObservers) {
            observer.onDetachedFromWindow(this);
        };
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        View result = super.onCreatePanelView(featureId);

        View temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onCreatePanelView(this, featureId);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple onCreatePanelView views cannot be created");
                }
            }
        }

        return result;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onMenuOpened(this, featureId, menu);
            } else {
                result = observer.onMenuOpened(this, featureId, menu);
            }
        }

        if (result) {
            super.onMenuOpened(featureId, menu);
        } else {
            result = super.onMenuOpened(featureId, menu);
        }

        return result;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onPrepareOptionsMenu(this, menu);
            } else {
                result = observer.onPrepareOptionsMenu(this, menu);
            }
        }

        if (result) {
            super.onPrepareOptionsMenu(menu);
        } else {
            result = super.onPrepareOptionsMenu(menu);
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onNavigateUp() {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onNavigateUp(this);
            } else {
                result = observer.onNavigateUp(this);
            }
        }

        if (result) {
            super.onNavigateUp();
        } else {
            result = super.onNavigateUp();
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onNavigateUpFromChild(this, child);
            } else {
                result = observer.onNavigateUpFromChild(this, child);
            }
        }

        if (result) {
            super.onNavigateUpFromChild(child);
        } else {
            result = super.onNavigateUpFromChild(child);
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);

        for (ActivityObserver observer : mObservers) {
            observer.onCreateNavigateUpTaskStack(this, builder);
        };
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);

        for (ActivityObserver observer : mObservers) {
            observer.onPrepareNavigateUpTaskStack(this, builder);
        };
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);

        for (ActivityObserver observer : mObservers) {
            observer.onOptionsMenuClosed(this, menu);
        };
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        for (ActivityObserver observer : mObservers) {
            observer.onCreateContextMenu(this, menu, v, menuInfo);
        };
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
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
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);

        for (ActivityObserver observer : mObservers) {
            observer.onContextMenuClosed(this, menu);
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog result = super.onCreateDialog(id);

        Dialog temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onCreateDialog(this, id);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple dialogs cannot be created");
                }
            }
        }

        return result;
    }

    @Nullable
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        Dialog result = super.onCreateDialog(id, args);

        Dialog temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onCreateDialog(this, id, args);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple dialogs cannot be created");
                }
            }
        }

        return result;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);

        for (ActivityObserver observer : mObservers) {
            observer.onPrepareDialog(this, id, dialog);
        };
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);

        for (ActivityObserver observer : mObservers) {
            observer.onPrepareDialog(this, id, dialog, args);
        };
    }

    @Override
    public boolean onSearchRequested() {
        boolean result = false;
        for (ActivityObserver observer : mObservers) {
            if (result) {
                observer.onSearchRequested(this);
            } else {
                result = observer.onSearchRequested(this);
            }
        }

        if (result) {
            super.onSearchRequested();
        } else {
            result = super.onSearchRequested();
        }

        return result;
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);

        for (ActivityObserver observer : mObservers) {
            observer.onApplyThemeResource(this, theme, resid, first);
        };
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        for (ActivityObserver observer : mObservers) {
            observer.onActivityReenter(this, resultCode, data);
        };
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);

        for (ActivityObserver observer : mObservers) {
            observer.onTitleChanged(this, title, color);
        };
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);

        for (ActivityObserver observer : mObservers) {
            observer.onChildTitleChanged(this, childActivity, title);
        };
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View result = super.onCreateView(parent, name, context, attrs);

        View temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onCreateView(this, parent, name, context, attrs);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple dialogs cannot be created");
                }
            }
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();

        for (ActivityObserver observer : mObservers) {
            observer.onVisibleBehindCanceled(this);
        };
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        for (ActivityObserver observer : mObservers) {
            observer.onEnterAnimationComplete(this);
        };
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        ActionMode result = super.onWindowStartingActionMode(callback);

        ActionMode temp;
        for (ActivityObserver observer : mObservers) {
            temp = observer.onWindowStartingActionMode(this, callback);
            if(temp != null) {
                if (result == null) {
                    result = temp;
                } else {
                    throw new IllegalStateException("Multiple actionmodes cannot be handled");
                }
            }
        }

        return result;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);

        for (ActivityObserver observer : mObservers) {
            observer.onActionModeStarted(this, mode);
        };
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);

        for (ActivityObserver observer : mObservers) {
            observer.onActionModeFinished(this, mode);
        };
    }

}
