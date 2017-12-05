package org.farfallettalaviano.simplecalculator;

/**
 * Created by Pj94 on 28/11/2017.
 */

import org.farfallettalaviano.simplecalculator.MainActivity;
import org.farfallettalaviano.simplecalculator.R;
import org.junit.Before;

import android.graphics.Rect;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivityLayoutTest extends
        ActivityInstrumentationTestCase2<MainActivity> {
    private View mainLayout;
    private MainActivity mainActivity;
    /**
     * Default constructor
     */
    public MainActivityLayoutTest() {
        super(MainActivity.class);
    }
    /**
     * Initialize result textview
     */
    protected void setUp() throws Exception {
        super.setUp();
//        mainActivity = getActivity();
        mainActivity = new MainActivity();
        mainLayout = (View) mainActivity.findViewById(R.id.MainLayout);
    }
    /**
     * Test Add button layout
     */
    public void testAddButtonOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        Button addButt = (Button) mainActivity.findViewById(R.id.addValues);
        addButt.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        addButt.getDrawingRect(outRect);
        assertTrue("Add button off the right of the screen", fullWidth
                + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Add button off the bottom of the screen", fullHeight
                + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }
    /**
     * Test Multiply button layout
     */
    public void testMultiplyButtonOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        Button multiplyButt = (Button) mainActivity
                .findViewById(R.id.multiplyValues);
        multiplyButt.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        multiplyButt.getDrawingRect(outRect);
        assertTrue("Multiply button off the right of the screen", fullWidth
                + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Multiply button off the bottom of the screen",
                fullHeight
                        + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }
    /**
     * Test Value1 input layout
     */
    public void testValue1EditTextOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        EditText value1 = (EditText) mainActivity
                .findViewById(R.id.value1);
        value1.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        value1.getDrawingRect(outRect);
        assertTrue("Value1 EditText off the right of the screen", fullWidth
                + mainLayoutLocation[0] >= outRect.width() + viewLocation[0]);
        assertTrue("Value1 EditText off the bottom of the screen",
                fullHeight
                        + mainLayoutLocation[1] >= outRect.height() + viewLocation[1]);
    }
    /**
     * Test Value2 input layout
     */
    public void testValue2EditTextOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        EditText value2 = (EditText) mainActivity
                .findViewById(R.id.value2);
        value2.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        value2.getDrawingRect(outRect);
        assertTrue("Value2 EditText off the right of the screen", fullWidth
                + mainLayoutLocation[0] >= outRect.width() + viewLocation[0]);
        assertTrue("Value2 EditText off the bottom of the screen",
                fullHeight
                        + mainLayoutLocation[1] >= outRect.height() + viewLocation[1]);
    }
}

