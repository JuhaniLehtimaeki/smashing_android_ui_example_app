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
package com.androiduipatterns.smashingandroidui.examples.animation;

import java.util.HashMap;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;

@TargetApi(11)
public class PropertyAnimationExampleActivity extends SherlockActivity {

    private ViewGroup componentOne;
    private ViewGroup componentTwo;

    private Button switchBomponentsButton;

    private boolean componentOneVisible = true;

    private AnimatorSet set;

    private static String[] items = { "AccelerateDecelerateInterpolator",
            "AccelerateInterpolator", " AnticipateInterpolator",
            "AnticipateOvershootInterpolator", "BounceInterpolator",
            " CycleInterpolator", "DecelerateInterpolator",
            "LinearInterpolator", "OvershootInterpolator" };
    private static HashMap<String, Interpolator> interpolatorMap = new HashMap<String, Interpolator>();
    static {
        interpolatorMap.put(items[0], new AccelerateDecelerateInterpolator());
        interpolatorMap.put(items[1], new AccelerateInterpolator());
        interpolatorMap.put(items[2], new AnticipateInterpolator());
        interpolatorMap.put(items[3], new AnticipateOvershootInterpolator());
        interpolatorMap.put(items[4], new BounceInterpolator());
        interpolatorMap.put(items[5], new CycleInterpolator(2f));
        interpolatorMap.put(items[6], new DecelerateInterpolator());
        interpolatorMap.put(items[7], new LinearInterpolator());
        interpolatorMap.put(items[8], new OvershootInterpolator());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Property Animation");

        setContentView(R.layout.property_animation_example);

        componentOne = (ViewGroup) findViewById(R.id.component_one);
        componentTwo = (ViewGroup) findViewById(R.id.component_two);

        final Spinner spinner = (Spinner) findViewById(R.id.interpolator_spinner);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        switchBomponentsButton = (Button) findViewById(R.id.switch_components_button);

        // Note that this code can be optimized.
        // This version demonstrates the functionality better!
        switchBomponentsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (componentOneVisible) {

                    final ObjectAnimator testOut = ObjectAnimator
                            .ofPropertyValuesHolder(componentOne,
                                    PropertyValuesHolder
                                            .ofFloat("alpha", 1, 0f),
                                    PropertyValuesHolder.ofFloat(
                                            "translationY",
                                            componentOne.getHeight()));

                    final ObjectAnimator testIn = ObjectAnimator
                            .ofPropertyValuesHolder(componentTwo,
                                    PropertyValuesHolder.ofFloat("alpha", 0f,
                                            1f), PropertyValuesHolder.ofFloat(
                                            "translationY", 0));

                    if (set != null && set.isRunning()) {
                        set.cancel();
                    }

                    set = new AnimatorSet();
                    set.playTogether(testOut, testIn);
                    set.setInterpolator(interpolatorMap.get(spinner.getSelectedItem()));
                    set.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            componentTwo.setVisibility(View.VISIBLE);
                            componentTwo.setTranslationY(componentTwo
                                    .getHeight());
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            componentOne.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            componentOne.setVisibility(View.GONE);
                            componentOne.setTranslationY(componentOne
                                    .getHeight());
                            componentTwo.setTranslationY(0);

                        }
                    });
                    set.setDuration(3000).start();

                } else {

                    final ObjectAnimator testOut = ObjectAnimator
                            .ofPropertyValuesHolder(componentTwo,
                                    PropertyValuesHolder
                                            .ofFloat("alpha", 1, 0f),
                                    PropertyValuesHolder.ofFloat(
                                            "translationY",
                                            componentTwo.getHeight()));

                    final ObjectAnimator testIn = ObjectAnimator
                            .ofPropertyValuesHolder(componentOne,
                                    PropertyValuesHolder.ofFloat("alpha", 0f,
                                            1f), PropertyValuesHolder.ofFloat(
                                            "translationY", 0));

                    if (set != null && set.isRunning()) {
                        set.cancel();
                    }

                    set = new AnimatorSet();
                    set.playTogether(testOut, testIn);
                    set.setInterpolator(interpolatorMap.get(spinner.getSelectedItem()));
                    set.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            componentOne.setVisibility(View.VISIBLE);
                            componentOne.setTranslationY(componentOne
                                    .getHeight());
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            componentTwo.setVisibility(View.GONE);

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            componentTwo.setVisibility(View.GONE);
                            componentTwo.setTranslationY(componentTwo
                                    .getHeight());
                            componentOne.setTranslationY(0);

                        }
                    });
                    
                    set.setDuration(3000).start();

                }

                componentOneVisible = !componentOneVisible;
            }
        });

    }

}
