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

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;

public class TweenAnimationExampleActivity extends SherlockActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Tween Animation");

        setContentView(R.layout.tween_animation_example);

        final ViewGroup componentOne = (ViewGroup) findViewById(R.id.component_one);
        Button animateButton = (Button) findViewById(R.id.animate_button_simple);
        animateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(TweenAnimationExampleActivity.this, R.anim.example_tween_anim_simple);
                componentOne.startAnimation(hyperspaceJumpAnimation);
                
            }
        });

        
        
        Button animateButtonComplex = (Button) findViewById(R.id.animate_button_complex);
        animateButtonComplex.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(TweenAnimationExampleActivity.this, R.anim.example_tween_complex);
                componentOne.startAnimation(hyperspaceJumpAnimation);
                
            }
        });

        
    }

}
