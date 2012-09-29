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
package com.androiduipatterns.smashingandroidui.examples.buy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class BuyActivity extends SherlockActivity {

    private GoogleAnalyticsTracker tracker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        
        tracker = GoogleAnalyticsTracker.getInstance();
        tracker.trackPageView("/BuyActivity");
        
        
        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_VIEW, 
                                Uri.parse("https://play.google.com/store/books/details/Juhani_Lehtimaki_Smashing_Android_UI?id=993PJfzW5rYC"));
                        startActivity(i);
                        
                        tracker.trackEvent(
                                "Buy",  // Category
                                "Button",  // Action
                                "Play Store", // Label
                                77);       // Value
                          

                    }
                });

        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(Intent.ACTION_VIEW, 
                                Uri.parse("http://www.amazon.com/dp/1118387287/ref=as_li_qf_sp_asin_til?tag=anduidespat-20&camp=0&creative=0&linkCode=as1&creativeASIN=1118387287&adid=09R70T4AM7NX8D7KE8NX"));
                        startActivity(i);
                        
                        tracker.trackEvent(
                                "Buy",  // Category
                                "Button",  // Action
                                "Amazon US", // Label
                                78);       // Value

                    }
                });

        findViewById(R.id.button3).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_VIEW, 
                                Uri.parse("http://www.amazon.co.uk/Smashing-Android-Magazine-Book-Series/dp/1118387287"));
                        startActivity(i);
                        
                        tracker.trackEvent(
                                "Buy",  // Category
                                "Button",  // Action
                                "Amazon UK", // Label
                                79);       // Value

                    }
                });

        findViewById(R.id.button4).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_VIEW, 
                                Uri.parse("https://www.amazon.de/dp/1118387287/ref=as_li_qf_sp_asin_til?tag=anduipat-21&camp=1410&creative=6378&linkCode=as1&creativeASIN=1118387287&adid=0GTY0E8ETKJQ4N4QQ4D3&"));
                        startActivity(i);
                        
                        
                        tracker.trackEvent(
                                "Buy",  // Category
                                "Button",  // Action
                                "Amazon DE", // Label
                                80);       // Value

                    }
                });
        
    }

}
