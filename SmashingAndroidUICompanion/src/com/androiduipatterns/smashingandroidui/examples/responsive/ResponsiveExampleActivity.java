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
package com.androiduipatterns.smashingandroidui.examples.responsive;

import com.androiduipatterns.smashingandroidui.examples.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResponsiveExampleActivity extends Activity implements
        ColorSelection {
    public static final int COLOR_RED = 0;
    public static final int COLOR_GREEN = 1;
    public static final int COLOR_BLUE = 2;

    // identifiers of different possible layouts
    private static int LAYOUT_ONE_COLUMN = 1;
    private static int LAYOUT_TWO_COLUMN = 2;
    private static int LAYOUT_THREE_COLUMN = 3;

    private int currentLayout = LAYOUT_ONE_COLUMN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        setTitle("Colors");

        setContentView(R.layout.example_fragment_layout);

        View colorFrame = findViewById(R.id.color_frame);
        View colorInfoFrame = findViewById(R.id.color_info_frame);

        // figure out which layout is in use so the actions can be redirected
        // correctly
        if (colorInfoFrame != null) {
            currentLayout = LAYOUT_THREE_COLUMN;
        } else if (colorFrame != null) {
            currentLayout = LAYOUT_TWO_COLUMN;
        } else {
            currentLayout = LAYOUT_ONE_COLUMN;
        }

    }

    /**
     * This is called when user presses one of the color buttons
     * 
     */
    public void setColor(int color) {

        if (currentLayout == LAYOUT_THREE_COLUMN
                || currentLayout == LAYOUT_TWO_COLUMN) { // just change
                                                         // fragments

            ColorFragment colorFragment = (ColorFragment) getFragmentManager()
                    .findFragmentById(R.id.color_frame);
            if (colorFragment == null || colorFragment.getColorShown() != color) {

                if (currentLayout == LAYOUT_THREE_COLUMN) {
                    colorFragment = ColorFragment.newInstance(color, false);
                } else {
                    colorFragment = ColorFragment.newInstance(color, true);
                }

                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.color_frame, colorFragment);

                // info only shown on three column layout
                if (currentLayout == LAYOUT_THREE_COLUMN) {

                    ColorInfoFragment colorInfoFragment = (ColorInfoFragment) getFragmentManager()
                            .findFragmentById(R.id.color_info_frame);
                    if (colorInfoFragment == null
                            || colorInfoFragment.getColorShown() != color) {

                        colorInfoFragment = ColorInfoFragment
                                .newInstance(color);

                        ft.replace(R.id.color_info_frame, colorInfoFragment);
                    }
                }

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else { // launch other activity
            Intent intent = new Intent(this,
                    ResponsiveExampleColorDetailsActivity.class);
            intent.putExtra("color", color);
            startActivity(intent);
        }

    }

    /**
     * This is called when user presses show info button (not available on
     * largest layout)
     */
    @Override
    public void colorDetailsSelected(int color) {
        // if this gets called it is 2 column layout

        Intent intent = new Intent(this,
                ResponsiveExampleColorDetailsActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }
}
