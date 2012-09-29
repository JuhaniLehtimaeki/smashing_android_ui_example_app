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
package com.androiduipatterns.smashingandroidui.examples;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.buy.BuyActivity;
import com.androiduipatterns.smashingandroidui.examples.example.ExamplesController;
import com.androiduipatterns.smashingandroidui.examples.example.ExamplesListActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class CoverActivity extends SherlockActivity {

    private GoogleAnalyticsTracker tracker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tracker = GoogleAnalyticsTracker.getInstance();
        tracker.trackPageView("/CoverActivity");
        
        setContentView(R.layout.activity_cover);
        setTitle("Smashing Android UI");

        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent newIntent = new Intent(CoverActivity.this,
                                ExamplesListActivity.class);
                        startActivity(newIntent);

                    }
                });

        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent goToMarket = new Intent(Intent.ACTION_VIEW).setData(Uri
                                .parse("market://details?id=me.scan.android.client"));
                        startActivity(goToMarket);

                    }
                });

        findViewById(R.id.button3).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent newIntent = new Intent(CoverActivity.this,
                                BuyActivity.class);
                        startActivity(newIntent);

                    }
                });

        findViewById(R.id.button4).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/JuhaniLehtimaeki/smashing_android_ui_example_app"));
                        startActivity(i);

                    }
                });

        if (getIntent() != null && getIntent().getData() != null) {
            onNewIntent(getIntent());
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("test", "intent " + intent);

        if (intent.getData() != null) {

            Log.d("test", "data " + intent.getData());

            String host = intent.getData().getHost();

            if (host == null) {
                Toast.makeText(this,
                        "No host in intent data " + intent.getData(),
                        Toast.LENGTH_LONG).show();
                return;
            }
            int id = -1;
            try {
                id = Integer.parseInt(host);
                Class activityToLaunch = ExamplesController.getInstance()
                        .getActivityByID(id);

                if (activityToLaunch == null) {
                    Toast.makeText(
                            this,
                            "Error figuring out which example should be started",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if (activityToLaunch.equals(ExamplesListActivity.class)) {
                    Toast.makeText(
                            CoverActivity.this,
                            "This example isn't ready yet. It will be added in the next update.",
                            Toast.LENGTH_LONG).show();
                }

                Intent newIntent = new Intent(this, activityToLaunch);
                startActivity(newIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
