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
package com.androiduipatterns.smashingandroidui.examples.example;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.androiduipatterns.smashingandroidui.examples.R;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class ExamplesListActivity extends SherlockFragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examples_list);

        setTitle("Browse Examples");
        
        GoogleAnalyticsTracker tracker = GoogleAnalyticsTracker.getInstance();
        tracker.trackPageView("/ExamplesListActivity");
        
    }

}