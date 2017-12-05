package org.farfallettalaviano.simplecalculator;

/**
 * Created by Pj94 on 29/11/2017.
 */
import org.farfallettalaviano.simplecalculator.R;
import org.farfallettalaviano.simplecalculator.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MainActivityMultiplyTest extends
        ActivityInstrumentationTestCase2<MainActivity> {
    private TextView result;
    private static final String N0 = "0";
    private static final String N1 = "1";
    private static final String N2 = "2";
    private static final String N4 = "4";
    private static final String N5 = "5";
    private static final String N7 = "7";
    private static final String ENTER = "ENTER";
    private static final String DOT = "NUMPAD_DOT";
    private static final String MINUS = "NUMPAD_SUBTRACT";
    private static final String RIGHT = "DPAD_RIGHT";
    private static final String N_24_E = enqueue(N2, N4, ENTER);
    private static final String N_74_E = enqueue(N7, N4, ENTER);
    private static final String N_5_DOT_5_E = enqueue(N5, DOT, N5, ENTER);
    private static final String MINUS_N10_E = enqueue(MINUS, N1, N0, ENTER);
    private static final String MULTIPLY_RESULT;
    private static final String MULTIPLY_DECIMAL_RESULT;
    private static final String MULTIPLY_MINUS_RESULT;
    static {
        MULTIPLY_RESULT = String.valueOf(Integer.valueOf(N2 + N4) * Integer.valueOf(N7 + N4));
        MULTIPLY_DECIMAL_RESULT = String.valueOf(Double.valueOf(N5 + "." + N5) * Integer.valueOf(N7 + N4));
        MULTIPLY_MINUS_RESULT = String.valueOf(Integer.valueOf("-" + N1 + N0) * Integer.valueOf(N7 + N4));
    }
    private static String enqueue(String... args) {
        StringBuilder toRet = new StringBuilder();
        for (String s : args) {
            toRet.append(s);
            toRet.append(" ");
        }
        return toRet.toString();
    }
    /**
     * Default constructor
     */
    public MainActivityMultiplyTest() {
        super(MainActivity.class);
    }
    /**
     * Initialize result textview
     */
    protected void setUp() throws Exception {
        super.setUp();
//        MainActivity mainActivity = getActivity();
        MainActivity mainActivity = new MainActivity();
        result = (TextView)
                mainActivity.findViewById(R.id.result);
    }
    /**
     * Test multiply integer
     */
    public void testMultiplyValues() {
        // Send 24 to value1
        sendKeys(N_24_E);
        // Send 74 to value2
        sendKeys(N_74_E);
        // Send Right pad sig
        sendKeys(RIGHT);
        // Send Enter button
        sendKeys(ENTER);
        // Get result
        String mathResult = result.getText().toString();
        assertTrue("Multiply result should be " + MULTIPLY_RESULT
                + " but was " + mathResult, mathResult.equals(MULTIPLY_RESULT));
    }
    /**
     * Test multiply decimal number
     */
    public void testMultiplyDecimalValues() {
        // Send 5.5 to value1
        sendKeys(N_5_DOT_5_E);
        // Send 74 to value2
        sendKeys(N_74_E);
        // Send Right pad sig
        sendKeys(RIGHT);
        // Send Enter button
        sendKeys(ENTER);
        // Get result
        String mathResult = result.getText().toString();
        assertFalse("Multiply result should be " + MULTIPLY_DECIMAL_RESULT
                + " but was " + mathResult, mathResult.equals(MULTIPLY_DECIMAL_RESULT));
    }
    /**
     * Test multiply negative number
     */
    public void testMultiplyNegativeValues() {
        // Send -10 to value1
        sendKeys(MINUS_N10_E);
        // Send 74 to value2
        sendKeys(N_74_E);
        // Send Right pad sig
        sendKeys(RIGHT);
        // Send Enter button
        sendKeys(ENTER);
        // Get result
        String mathResult = result.getText().toString();
        assertFalse("Multiply result should be " + MULTIPLY_MINUS_RESULT
                + " but was " + mathResult, mathResult.equals(MULTIPLY_MINUS_RESULT));
    }
}
