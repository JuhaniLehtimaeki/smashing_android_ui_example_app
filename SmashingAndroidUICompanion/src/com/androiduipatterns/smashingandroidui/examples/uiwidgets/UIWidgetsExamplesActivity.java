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
package com.androiduipatterns.smashingandroidui.examples.uiwidgets;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;
import com.viewpagerindicator.TitlePageIndicator;

@TargetApi(11)
public class UIWidgetsExamplesActivity extends SherlockActivity {

    
    private static String[] items = { "item 1",
        "item 2", " item 3"};
    
    
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("UI Widgets");

        setContentView(R.layout.ui_widgets_example);

        UIWidgetPagerAdapter adapter = new UIWidgetPagerAdapter();
        ViewPager myPager = (ViewPager) findViewById(R.id.ui_widget_viewpager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);
        
        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.indicator);

        indicator.setViewPager(myPager);
//        indicator.setFooterColor(0xFF000000);
        
        


        
    }

    private class UIWidgetPagerAdapter extends PagerAdapter{

        public int getCount() {
            return 8;
        }

        public Object instantiateItem(View collection, int position) {

            LayoutInflater inflater = (LayoutInflater) collection.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            int resId = 0;
            switch (position) {
            case 0:
                resId = R.layout.ui_widgets_text_widgets_example;
                break;
            case 1:
                resId = R.layout.ui_widgets_buttons_example;
                break;
            case 2:
                resId = R.layout.ui_widgets_spinner_number_example;
                break;
            case 3:
                resId = R.layout.ui_widgets_switches_example;
                break;
            case 4:
                resId = R.layout.ui_widgets_datetime_example;
                break;
            case 5:
                resId = R.layout.ui_widgets_calendar_example;
                break;
                
            case 6:
                resId = R.layout.ui_widgets_progressbar_example;
                break;
                
            case 7:
                resId = R.layout.ui_widgets_sliding_drawer_example;
                break;

            }

            View view = inflater.inflate(resId, null);

            ((ViewPager) collection).addView(view, 0);

            
            
            switch (position) {
            case 2:
                
                final Spinner spinner = (Spinner) view.findViewById(R.id.example_spinner);
                final Spinner spinnerTwo = (Spinner) view.findViewById(R.id.example_spinner_two);
                ArrayAdapter<String> aa = new ArrayAdapter<String>(UIWidgetsExamplesActivity.this,
                        android.R.layout.simple_spinner_item, items);

                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(aa);
                spinnerTwo.setAdapter(aa);
                
                
                NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.number_picker);
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(10);
                break;


            }

            
            
            
            
            return view;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);

        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
            case 0:
                return "Text Widgets";
            case 1:
                return "Buttons";
            case 2:
                return "Spinner, number picker";
            case 3:
                return "Switches";
            case 4:
                return "Date and time";
            case 5:
                return "Calendar";
            case 6:
                return "Progress bar";
            case 7:
                return "Sliding drawer";
            }
            return "unknown";
        }
    }

}
