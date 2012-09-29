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

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.androiduipatterns.smashingandroidui.examples.R;

public class ResponsiveExampleColorInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Color Info");
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int color = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            color = extras.getInt("color");
        }

        setContentView(R.layout.example_fragment_color_info_layout);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ColorInfoFragment colorInfoFragment = ColorInfoFragment
                .newInstance(color);
        ft.add(R.id.color_info_frame, colorInfoFragment);

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
     
        switch (item.getItemId()) {
        case android.R.id.home:
           finish();
           return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

}
