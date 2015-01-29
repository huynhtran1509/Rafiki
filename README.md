Rafiki
==================

One of the major annoyances when writing an android library is that, at times, a library needs to know when certain lifecycle events occur. In the past there have been two approaches. 

1. Force the user to extend your activity or fragment
2. Force the user to make lifecycle callbacks at the appropriate times

Option 1 is a non-starter because once one library forced you to extend the activity or fragment then all other libraries became pointless.

Option 2 is not the best because it involves manual work and if your library is complex then it may need a number of lifecycle events. In addition, if you need to add awareness of a lifecycle event then you have to rely on the users noticing that requriement when updating your library.

Therefore I came up with the concept of Android Observables. Basically by extending the Activity or Fragments that I provided you can provide hooks that other libraries can tie into. Below is an example of an ActivityModule that simply adds a menu to all activities you add it to:
```java
public class SettingsMenuModule extends AbstractActivityListener {

    @Override
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        activity.getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
        if(item.getItemId() == R.id.settings) {
            Toast.makeText(activity, "Settings Selected", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
```

You'll note that the syntax almost looks like you're extending the activity yourself. It's really that simple of a concept and I hope that it will add to complex/flexible libraries that are trivial to implement in your own app.

As a side benefit, since you're no longer extending an Activity or Fragment your code is already inherently more unit testable. Included in the samples you can see plain old unit tests that test an activity module without any form of android emulation. Granted that tests here will be limited in their current form, but hopefully some combination of this and robolectric can provide a format in which it will be trivial to write more complicated unit tests. Once we gauge the interest here we'll work to investigating this further. See the below class for a quick example:
https://github.com/willowtreeapps/Rafiki/blob/master/sample/src/test/java/com/willowtreeapps/rafiki/observersample/activitymodules/SettingsMenuModuleTest.java
