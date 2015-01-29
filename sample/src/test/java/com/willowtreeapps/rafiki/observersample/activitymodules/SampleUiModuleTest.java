package com.willowtreeapps.rafiki.observersample.activitymodules;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.willowtreeapps.rafiki.DispatchActivity;
import com.willowtreeapps.rafiki.observersample.mockutils.MockGenerator;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Button.class, TextView.class, FragmentActivity.class})
public class SampleUiModuleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOnCreate() throws Exception {

        SampleLoaderLikeNetworkModule loaderModule = mock(SampleLoaderLikeNetworkModule.class);
        //Setup
        SampleUiModule module = new SampleUiModule(loaderModule);
        DispatchActivity mocking = MockGenerator.getMockActivity(module);

        //Actual test
        module.onCreate(mocking, null);

        //Verification
        assertNotNull(module.mButton);
        verify(module.mButton).setOnClickListener(any(View.OnClickListener.class));
    }
}