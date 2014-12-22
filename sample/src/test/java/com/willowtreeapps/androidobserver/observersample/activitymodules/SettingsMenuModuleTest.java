package com.willowtreeapps.androidobserver.observersample.activitymodules;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.TextView;

import com.willowtreeapps.androidobservables.ObservableActivity;
import com.willowtreeapps.androidobserver.observersample.R;
import com.willowtreeapps.androidobserver.observersample.mockutils.MockGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Button.class, TextView.class, FragmentActivity.class})
public class SettingsMenuModuleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOnCreateOptionsMenu() throws Exception {
        //Setup
        SettingsMenuModule module = new SettingsMenuModule();
        ObservableActivity mocking = MockGenerator.getMockActivity(module);

        Menu menu = mock(Menu.class);
        MenuInflater inflater = mock(MenuInflater.class);
        when(mocking.getMenuInflater()).thenReturn(inflater);

        //Actual test
        module.onCreateOptionsMenu(mocking, menu);

        //Verification
        verify(inflater).inflate(R.menu.settings, menu);
    }
}