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

import java.util.LinkedList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockListFragment;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class ExamplesListFragment extends SherlockListFragment {

    private GoogleAnalyticsTracker tracker;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        tracker = GoogleAnalyticsTracker.getInstance();

        LinkedList<ExampleItem> items = ExamplesController.getInstance()
                .getItems();

        final ExamplesListAdapter adapter = new ExamplesListAdapter(
                getActivity(), items);

        setListAdapter(adapter);

        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int position, long id) {

                        ExampleItem item = ((ExampleItem) getListAdapter()
                                .getItem(position));

                        if (item.getMinAPILevel() > android.os.Build.VERSION.SDK_INT) {
                            Toast.makeText(
                                    getActivity(),
                                    "This example is not compatible with your device.",
                                    Toast.LENGTH_LONG).show();
                            return;

                        }

                        Intent intent = new Intent(getActivity(), item
                                .getActivityToStart());
                        startActivity(intent);
                        
                        
                        tracker.trackEvent(
                                "Examples",  // Category
                                "Start exampel",  // Action
                                item.getTitle(), // Label
                                10);       // Value
                        
                    }
                });
    }
}
