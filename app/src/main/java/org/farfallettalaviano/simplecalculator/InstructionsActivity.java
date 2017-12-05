package org.farfallettalaviano.simplecalculator;

/**
 * Created by Stefano Farfalletta on 28/11/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstructionsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        Button addButton = (Button) findViewById(R.id.back);
        addButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                InstructionsActivity.this.finish();
            }
        });
    }
}

