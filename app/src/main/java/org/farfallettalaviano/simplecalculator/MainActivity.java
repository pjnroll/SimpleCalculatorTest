package org.farfallettalaviano.simplecalculator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class MainActivity extends Activity {
    final static String LOG_TAG = "MainScreen";

    private EditText mTxtValue1;
    private EditText mTxtValue2;


    private TextView mTxtResult;

    private float mValue1;
    private float mValue2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtValue1 = findViewById(this, R.id.txtVal1);
        mTxtValue2 = findViewById(this, R.id.txtVal2);
        mTxtResult = findViewById(this, R.id.txtResult);

        Button mBtnAdd = findViewById(this, R.id.btnAdd);
        Button mBtnSubtract = findViewById(this, R.id.btnSubtract);
        Button mBtnMultiply = findViewById(this, R.id.btnMultiply);
        Button mBtnDivide = findViewById(this, R.id.btnDivide);

        View.OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                float result = 0f;
                switch (v.getId()) {
                    case (R.id.btnAdd):
                        result = addValues();
                        break;

                    case (R.id.btnSubtract):
                        result = subtractValues();
                        break;

                    case (R.id.btnMultiply):
                        result = multiplyValues();
                        break;

                    case (R.id.btnDivide):
                        result = divideValues();
                        break;

                    default:
                        break;
                }
                hideKeyboard(getCurrentFocus());
                mTxtResult.setText(String.valueOf(result));
            }
        };

        mBtnAdd.setOnClickListener(listener);
        mBtnSubtract.setOnClickListener(listener);
        mBtnMultiply.setOnClickListener(listener);
        mBtnDivide.setOnClickListener(listener);
    }

    private class MyErrorListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            TextView t = findViewById(R.id.txtResult);
            t.setText("");
        }
    }

    private float addValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 + mValue2;
        } catch (NumberFormatException ne) {
            Log.e(LOG_TAG, "Empty values");
            Snackbar.make(findViewById(this, R.id.llMain), "Empty values", LENGTH_LONG)
                    .setAction("Ok", new MyErrorListener())
                    .setActionTextColor(Color.RED)
                    .show();
        }
        return toRet;
    }

    private float multiplyValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 * mValue2;
        } catch (NumberFormatException ne) {
            Log.e(LOG_TAG, "Empty values");
            Snackbar.make(findViewById(this, R.id.llMain), "Empty values", LENGTH_LONG)
                    .setAction("Ok", new MyErrorListener())
                    .setActionTextColor(Color.RED)
                    .show();
        }
        return toRet;
    }

    private float subtractValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());

            toRet = mValue1 - mValue2;
        } catch (NumberFormatException ne) {
            Log.e(LOG_TAG, "Empty values");
            Snackbar.make(findViewById(this, R.id.llMain), "Empty values", LENGTH_LONG)
                    .setAction("Ok", new MyErrorListener())
                    .setActionTextColor(Color.RED)
                    .show();
        }
        return toRet;
    }

    private float divideValues () {
        float toRet = -1;
        try {
            mValue1 = Float.valueOf(mTxtValue1.getText().toString());
            mValue2 = Float.valueOf(mTxtValue2.getText().toString());
            if (Float.compare(mValue2, 0f) == 0)
                throw new ArithmeticException();

            toRet = mValue1 / mValue2;
        } catch (NumberFormatException ne) {
            Log.e(LOG_TAG, "Empty values");
            Snackbar.make(findViewById(this, R.id.llMain), "Empty values", LENGTH_LONG)
                    .setAction("Ok", new MyErrorListener())
                    .setActionTextColor(Color.RED)
                    .show();
        } catch (ArithmeticException ae) {
            Log.e(LOG_TAG, "Divide by 0");
            Snackbar.make(findViewById(this, R.id.llMain), "Can't divide by 0", LENGTH_LONG)
                    .setAction("Ok", new MyErrorListener())
                    .setActionTextColor(Color.RED)
                    .show();
        }
        return toRet;
    }

    private void hideKeyboard(View v) {
        if (v != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    /**
     * this method let to avoid casting every time the Views to their specific sub-classes;
     * @param act the activity that contains the View
     * @param viewId the id of the view to be returned
     * @param <T> the class parameter to be returned
     * @return the casted view
     */
    public static <T extends View> T findViewById(Activity act, int viewId) {
        View containerView = act.getWindow().getDecorView();
        View toRet = containerView.findViewById(viewId);

        return (T) toRet;
    }
}