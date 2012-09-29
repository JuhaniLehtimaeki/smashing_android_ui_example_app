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
package com.androiduipatterns.smashingandroidui.examples.expand;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;

public class ExpandInContextActivity extends SherlockActivity {

    private boolean isExpanded = false;
    private int lastHeight = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_in_context);

        final ViewGroup expandableContainer = (ViewGroup) findViewById(R.id.expandable_container);

        findViewById(R.id.expandable_text).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (isExpanded) {
                            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) expandableContainer
                                    .getLayoutParams();

                            params.height = lastHeight;

                            expandableContainer.setLayoutParams(params);
                            expandableContainer.invalidate();
                        } else {
                            lastHeight = expandableContainer.getHeight();

                            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) expandableContainer
                                    .getLayoutParams();

                            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;

                            expandableContainer.setLayoutParams(params);
                            expandableContainer.invalidate();
                        }

                        isExpanded = !isExpanded;

                    }
                });

    }

}
