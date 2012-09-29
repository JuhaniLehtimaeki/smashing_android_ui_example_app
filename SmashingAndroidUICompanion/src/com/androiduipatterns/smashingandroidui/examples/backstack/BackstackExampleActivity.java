/*
 * Copyright (C) 2012 Juhani Lehtimaki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.androiduipatterns.smashingandroidui.examples.backstack;

import java.util.HashMap;
import java.util.LinkedList;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;

public class BackstackExampleActivity extends SherlockActivity {

    public static int colorA = 0xff886666;
    public static int colorB = 0xff668866;
    public static int colorC = 0xff666688;

    private static int countA = 0;
    private static int countB = 0;
    private static int countC = 0;

    private static LinkedList<BackstackExampleActivity> stackTracker = new LinkedList<BackstackExampleActivity>();
    private static HashMap<BackstackExampleActivity, String> activityToLabelMap = new HashMap<BackstackExampleActivity, String>();

    private static HashMap<String, Integer> spinnerValues = new HashMap<String, Integer>();
    private static String[] spinnerLabels = new String[4];
    static {

        spinnerValues.put("No flags", 0);
        spinnerLabels[0] = "No flags";

        spinnerValues.put("FLAG_ACTIVITY_NEW_TASK",
                Intent.FLAG_ACTIVITY_NEW_TASK);
        spinnerLabels[1] = "FLAG_ACTIVITY_NEW_TASK";

        spinnerValues.put("FLAG_ACTIVITY_CLEAR_TOP",
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        spinnerLabels[2] = "FLAG_ACTIVITY_CLEAR_TOP";

        spinnerValues.put("FLAG_ACTIVITY_SINGLE_TOP",
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        spinnerLabels[3] = "FLAG_ACTIVITY_SINGLE_TOP";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Activity Back Stack Example");

        setContentView(R.layout.back_stack_example);

        Button buttonA = (Button) findViewById(R.id.activity_a_button);
        buttonA.setBackgroundColor(colorA);
        Button buttonB = (Button) findViewById(R.id.activity_b_button);
        buttonB.setBackgroundColor(colorB);
        Button buttonC = (Button) findViewById(R.id.activity_c_button);
        buttonC.setBackgroundColor(colorC);

        TextView idText = (TextView) findViewById(R.id.activity_id);

        final Spinner activityFlagSpinner = (Spinner) findViewById(R.id.activity_flag_spinner);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerLabels);
        spinnerArrayAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        activityFlagSpinner.setAdapter(spinnerArrayAdapter);

        if (this instanceof BackstackExampleActivityA) {
            ++countA;
            idText.setText("Activity A " + countA);
            stackTracker.add(this);
            activityToLabelMap.put(this, "Activity A " + countA);
            idText.setBackgroundColor(colorA);

        } else if (this instanceof BackstackExampleActivityB) {
            ++countB;
            idText.setText("Activity B " + countB);
            stackTracker.add(this);
            activityToLabelMap.put(this, "Activity B " + countB);

            idText.setBackgroundColor(colorB);
        } else if (this instanceof BackstackExampleActivityC) {
            ++countC;
            idText.setText("Activity C " + countC);
            stackTracker.add(this);
            activityToLabelMap.put(this, "Activity C " + countC);

            idText.setBackgroundColor(colorC);
        } else {

        }

        buttonA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BackstackExampleActivity.this,
                        BackstackExampleActivityA.class);
                int flag = spinnerValues.get(activityFlagSpinner
                        .getSelectedItem());
                if (flag != 0) {
                    intent.setFlags(flag);
                }

                startActivity(intent);

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BackstackExampleActivity.this,
                        BackstackExampleActivityB.class);
                int flag = spinnerValues.get(activityFlagSpinner
                        .getSelectedItem());
                if (flag != 0) {
                    intent.setFlags(flag);
                }
                startActivity(intent);

            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BackstackExampleActivity.this,
                        BackstackExampleActivityC.class);
                int flag = spinnerValues.get(activityFlagSpinner
                        .getSelectedItem());
                if (flag != 0) {
                    intent.setFlags(flag);
                }
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (this instanceof BackstackExampleActivityA) {

        } else if (this instanceof BackstackExampleActivityB) {

        } else if (this instanceof BackstackExampleActivityC) {

        } else {

            countA = 0;
            countB = 0;
            countC = 0;
            activityToLabelMap.clear();
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                // sleep to let destroy finish before drawing back stack
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        final LinearLayout stack = (LinearLayout) findViewById(R.id.stack);
                        stack.removeAllViews();
                        for (BackstackExampleActivity activityInStack : stackTracker) {
                            TextView tv = new TextView(
                                    BackstackExampleActivity.this);

                            
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(5, 5, 5, 5);
                            tv.setLayoutParams(lp);
                            
                            
                            tv.setText(activityToLabelMap.get(activityInStack));

                            if (activityInStack instanceof BackstackExampleActivityA) {
                                tv.setBackgroundColor(colorA);
                            } else if (activityInStack instanceof BackstackExampleActivityB) {
                                tv.setBackgroundColor(colorB);
                            } else if (activityInStack instanceof BackstackExampleActivityC) {
                                tv.setBackgroundColor(colorC);
                            }

                            stack.addView(tv);
                        }
                    }
                });

            }
        }).start();

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        stackTracker.remove(this);
        super.onDestroy();

    }
}
