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

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@TargetApi(11)
public class ColorFragment extends Fragment {

    private int colorShown = ResponsiveExampleActivity.COLOR_RED;
    private boolean showInfoButton = false;
    
    public static ColorFragment newInstance(int color, boolean showInfoButton) {
        ColorFragment ret = new ColorFragment(color, showInfoButton);
        
        return ret;
    }


    public ColorFragment(int color, boolean showInfoButton) {
        this.colorShown = color;
        this.showInfoButton = showInfoButton;
    }

    public ColorFragment() {
    }
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.responsive_example_color,
                container, false);

        View colorView = view.findViewById(R.id.responsive_example_color_frame);

        if (this.colorShown == ResponsiveExampleActivity.COLOR_RED) {
            colorView.setBackgroundColor(0xFFFF0000);
        } else if (this.colorShown == ResponsiveExampleActivity.COLOR_GREEN) {
            colorView.setBackgroundColor(0xFF00FF00);
        } else if (this.colorShown == ResponsiveExampleActivity.COLOR_BLUE) {
            colorView.setBackgroundColor(0xFF0000FF);
        }
        
        // 3 column layout should not have this button
        
        Button colorInfoButton = (Button) view.findViewById(R.id.color_info_button);
        if(!showInfoButton){
            colorInfoButton.setVisibility(View.INVISIBLE);
        }else{
            
            colorInfoButton.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    ((ColorSelection)getActivity()).colorDetailsSelected(colorShown);
                }
            });
        }
        
        
       
        return view;
    }

    public int getColorShown() {
        return this.colorShown;
    }
}
