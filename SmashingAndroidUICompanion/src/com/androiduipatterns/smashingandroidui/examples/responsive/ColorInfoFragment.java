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
import android.widget.TextView;

public class ColorInfoFragment extends Fragment {

    private int colorShown = ResponsiveExampleActivity.COLOR_RED;

    public static ColorInfoFragment newInstance(int color) {
        ColorInfoFragment ret = new ColorInfoFragment(color);

        return ret;
    }

    public ColorInfoFragment() {
        this.colorShown = ResponsiveExampleActivity.COLOR_RED;
    }

    public ColorInfoFragment(int color) {
        this.colorShown = color;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.responsive_example_color_info,
                container, false);

        TextView colorTextView = (TextView) view
                .findViewById(R.id.responsive_example_color_info);

        if (this.colorShown == ResponsiveExampleActivity.COLOR_RED) {
            colorTextView.setText(R.string.responsive_example_red);
        } else if (this.colorShown == ResponsiveExampleActivity.COLOR_GREEN) {
            colorTextView.setText(R.string.responsive_example_green);
        } else if (this.colorShown == ResponsiveExampleActivity.COLOR_BLUE) {
            colorTextView.setText(R.string.responsive_example_blue);
        }
        return view;
    }

    public int getColorShown() {
        return this.colorShown;
    }

}
