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
package com.androiduipatterns.smashingandroidui.examples.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;
import com.viewpagerindicator.TitlePageIndicator;

public class FontsExampleActivity extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Fonts");

        setContentView(R.layout.fonts_example);

       

        TextsPagerAdapter adapter = new TextsPagerAdapter();
        ViewPager myPager = (ViewPager) findViewById(R.id.text_viewpager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);
        
        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.indicator);

        indicator.setViewPager(myPager);
        

    }

    private class TextsPagerAdapter extends PagerAdapter {

        public int getCount() {
            return 6;
        }

        public Object instantiateItem(View collection, int position) {

            LayoutInflater inflater = (LayoutInflater) collection.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            int resId = 0;
            switch (position) {
            case 0:
                resId = R.layout.fonts_custom_font;
                break;
            case 1:
                resId = R.layout.fonts_typefaces;
                break;
            case 2:
                resId = R.layout.fonts_styles;
                break;
            case 3:
                resId = R.layout.fonts_size;
                break;
            case 4:
                resId = R.layout.fonts_color;
                break;
            case 5:
                resId = R.layout.fonts_advanced;
                break;
            }

            View view = inflater.inflate(resId, null);

            ((ViewPager) collection).addView(view, 0);

            
            
            switch (position) {
            case 0:
                
                Typeface tf = Typeface.createFromAsset(getAssets(),
                        "fonts/Gamaliel.otf");
                TextView customFontTextView = (TextView) findViewById(R.id.CustomFontExampleTextOne);
                customFontTextView.setTypeface(tf);
                
                tf = Typeface.createFromAsset(getAssets(),
                        "fonts/DarkGardenMK.ttf");
                customFontTextView = (TextView) findViewById(R.id.CustomFontExampleTextTwo);
                customFontTextView.setTypeface(tf);
                
                tf = Typeface.createFromAsset(getAssets(),
                        "fonts/SchoolCursive.ttf");
                customFontTextView = (TextView) findViewById(R.id.CustomFontExampleTextThree);
                customFontTextView.setTypeface(tf);
                
                break;
            case 5:
                TextView textView = (TextView) findViewById(R.id.text_from_html);     
                textView.setText(Html.fromHtml("Example <b>HTML</b> text with a <a href=\"#\">link</a>"));
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
                return "Custom fonts";
            case 1:
                return "Typefaces";
            case 2:
                return "Styles";
            case 3:
                return "Size";
            case 4:
                return "Color and shadow";
            case 5:
                return "Advanced";
            }
            return "unknown";
        }
    }

}
