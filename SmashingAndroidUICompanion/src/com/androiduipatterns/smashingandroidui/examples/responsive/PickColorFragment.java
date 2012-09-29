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

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PickColorFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.responsive_example_color_picker,
                container, false);
        Button redButton = (Button) view
                .findViewById(R.id.responsive_example_red);
        redButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((ResponsiveExampleActivity) getActivity())
                        .setColor(ResponsiveExampleActivity.COLOR_RED);
            }
        });

        Button greenButton = (Button) view
                .findViewById(R.id.responsive_example_green);
        greenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((ResponsiveExampleActivity) getActivity())
                        .setColor(ResponsiveExampleActivity.COLOR_GREEN);
            }
        });

        Button blueButton = (Button) view
                .findViewById(R.id.responsive_example_blue);
        blueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((ResponsiveExampleActivity) getActivity())
                        .setColor(ResponsiveExampleActivity.COLOR_BLUE);
            }
        });
        return view;
    }
}
