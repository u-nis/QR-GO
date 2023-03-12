package com.example.qr_go;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.qr_go.Activities.Profile.ThisProfileQRListViewActivity;
import com.example.qr_go.Activities.QRView.QRViewActivity;
import com.robotium.solo.Solo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests QR list activity
 */
public class ProfileQRListTest {
    private Solo solo;

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{

        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */
    @Test
    public void start() throws Exception{
        Activity activity = rule.getActivity();
    }

    /**
     * Tests clicking on QR
     * Note: must have at least 1 QR in your account
     * @throws Exception
     */
    @Test
    public void testQRListClick() throws Exception{
        // get into QR list
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnView(solo.getView(R.id.navigation_profile));

        // Click on QR button
        solo.clickOnView(solo.getView(R.id.my_qr_codes_button));

        // assert we are in QR list
        solo.assertCurrentActivity("Wrong Activity", ThisProfileQRListViewActivity.class);

        // click on first item
        RecyclerView qrList = (RecyclerView) solo.getView(R.id.qr_list);
        solo.clickInRecyclerView(0);

        solo.assertCurrentActivity("Wrong Activity", QRViewActivity.class);
    }
}
