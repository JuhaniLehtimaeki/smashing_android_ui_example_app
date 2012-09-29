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

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;

@TargetApi(11)
public class LayoutAnimationExampleActivity extends SherlockActivity {

    private ViewGroup componentOne;
    private ViewGroup componentTwo;

    private ViewGroup componentContainer;

    private Button switchBomponentsButton;

    private Button customAnimButton;
    private Button defaultAnimButton;

    private boolean componentOneVisible = true;
    private LayoutTransition mTransitioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Layout Animation");

        setContentView(R.layout.layout_animation_example);

        componentOne = (ViewGroup) findViewById(R.id.component_one);
        componentTwo = (ViewGroup) findViewById(R.id.component_two);

        componentContainer = (ViewGroup) findViewById(R.id.component_container);

        switchBomponentsButton = (Button) findViewById(R.id.switch_components_button);
        defaultAnimButton = (Button) findViewById(R.id.reset_default_animation_button);
        customAnimButton = (Button) findViewById(R.id.set_custom_animation_button);

        switchBomponentsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (componentOneVisible) {
                    componentOne.setVisibility(View.GONE);
                    componentTwo.setVisibility(View.VISIBLE);
                } else {

                    componentTwo.setVisibility(View.GONE);
                    componentOne.setVisibility(View.VISIBLE);
                }

                componentOneVisible = !componentOneVisible;
            }
        });

        defaultAnimButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                resetTransition();

            }
        });

        customAnimButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resetTransition();
                setupCustomAnimations();
            }
        });

        resetTransition();
    }

    private void resetTransition() {
        mTransitioner = new LayoutTransition();
        componentContainer.setLayoutTransition(mTransitioner);
    }

    private void setupCustomAnimations() {


        final ObjectAnimator testIn = ObjectAnimator.ofPropertyValuesHolder(
                componentContainer,
                PropertyValuesHolder.ofFloat("scaleX", 0, 1f),
                PropertyValuesHolder.ofFloat("scaleY", 0, 1f),
                PropertyValuesHolder.ofFloat("alpha", 0f, 1f));

        testIn.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setScaleX(1f);
                view.setScaleY(1f);
                view.setAlpha(1f);
            }
        });
        
        testIn.setDuration(3000);
        

        final ObjectAnimator testOut = ObjectAnimator.ofPropertyValuesHolder(
                componentContainer,
                PropertyValuesHolder.ofFloat("scaleX", 1f, 0),
                PropertyValuesHolder.ofFloat("scaleY", 1f, 0),
                PropertyValuesHolder.ofFloat("alpha", 1, 0f));

        
        testOut.setDuration(3000);
        
        testOut.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setScaleX(0f);
                view.setScaleY(0f);
                view.setAlpha(0f);
            }
        });
        
        
        
        
        mTransitioner.setAnimator(LayoutTransition.APPEARING, testIn);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, testOut);

        mTransitioner.setDuration(5000);
        
        mTransitioner.setDuration(LayoutTransition.APPEARING, 3000);
        mTransitioner.setDuration(LayoutTransition.DISAPPEARING, 3000);
     

    }
}
