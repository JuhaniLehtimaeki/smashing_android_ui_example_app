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

import android.view.View;

import com.androiduipatterns.smashingandroidui.examples.SmashingAndroidUIExamplesActivity;
import com.androiduipatterns.smashingandroidui.examples.actionbar.ActionBarExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.animation.FrameAnimationExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.animation.LayoutAnimationExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.animation.PropertyAnimationExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.animation.TweenAnimationExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.backstack.BackstackExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.expand.ExpandInContextActivity;
import com.androiduipatterns.smashingandroidui.examples.fonts.FontsExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.GradientActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.GraphicsFromCodeActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.LayersActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.NinePatchActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.RotateScaleActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.TilingActivity;
import com.androiduipatterns.smashingandroidui.examples.graphics.XMLActivity;
import com.androiduipatterns.smashingandroidui.examples.intents.SendIntentExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.keyboard.ActionButtonActivity;
import com.androiduipatterns.smashingandroidui.examples.keyboard.InputModePanActivity;
import com.androiduipatterns.smashingandroidui.examples.keyboard.InputModeResizeActivity;
import com.androiduipatterns.smashingandroidui.examples.keyboard.InputTypeExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.FrameLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.GridLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.IncludeLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.LinearLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.PaddingLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.layouts.RelativeLayoutActivity;
import com.androiduipatterns.smashingandroidui.examples.notifications.NotificationsExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.responsive.ResponsiveExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.tabs.TabsExampleActivity;
import com.androiduipatterns.smashingandroidui.examples.uiwidgets.CustomUIWidgetsExamplesActivity;
import com.androiduipatterns.smashingandroidui.examples.uiwidgets.UIWidgetsExamplesActivity;

public class ExamplesController {

    private static ExamplesController instance = new ExamplesController();

    private LinkedList<ExampleItem> items = new LinkedList<ExampleItem>();

    private ExamplesController() {
        initExampleList();
    }

    public static ExamplesController getInstance() {
        return instance;
    }

    public LinkedList<ExampleItem> getItems() {
        return items;
    }

    public Class getActivityByID(int id) {
        for (ExampleItem exampleItem : items) {
            if (id == exampleItem.getId()) {

                if (exampleItem.getMinAPILevel() > android.os.Build.VERSION.SDK_INT) {
                    return ExamplesListActivity.class;
                }

                return exampleItem.getActivityToStart();
            }
        }
        return ExamplesListActivity.class;
    }

    private void initExampleList() {
        items.add(new ExampleItem("Send intent", 1, 6,
                SendIntentExampleActivity.class, 8));

        items.add(new ExampleItem("Back stack", 2, 7,
                BackstackExampleActivity.class, 8));

        items.add(new ExampleItem("Notifications", 100, 7,
                NotificationsExampleActivity.class, 16));

        items.add(new ExampleItem("Input method resize", 3, 10,
                InputModeResizeActivity.class, 8));

        items.add(new ExampleItem("Input method pan", 4, 10,
                InputModePanActivity.class, 8));

        items.add(new ExampleItem("Input types", 5, 10,
                InputTypeExampleActivity.class, 8));

        items.add(new ExampleItem("Action button", 6, 10,
                ActionButtonActivity.class, 8));

        items.add(new ExampleItem("Layout Animation", 7, 11,
                LayoutAnimationExampleActivity.class, 11));

        items.add(new ExampleItem("Property Animation", 8, 11,
                PropertyAnimationExampleActivity.class, 11));

        items.add(new ExampleItem("Tween Animation", 9, 11,
                TweenAnimationExampleActivity.class, 8));

        items.add(new ExampleItem("Frame Animation", 10, 11,
                FrameAnimationExampleActivity.class, 8));

        items.add(new ExampleItem("UI Widgets", 11, 11,
                UIWidgetsExamplesActivity.class, 11));

        items.add(new ExampleItem("Customizing UI Widgets", 12, 11,
                CustomUIWidgetsExamplesActivity.class, 8));

        items.add(new ExampleItem("Fonts", 13, 11, FontsExampleActivity.class,
                8));

        items.add(new ExampleItem("LinearLayout", 14, 13,
                LinearLayoutActivity.class, 8));

        items.add(new ExampleItem("RelativeLayout", 15, 13,
                RelativeLayoutActivity.class, 8));

        items.add(new ExampleItem("FrameLayout", 16, 13,
                FrameLayoutActivity.class, 8));

        items.add(new ExampleItem("GridLayout", 17, 13,
                GridLayoutActivity.class, 14));

        items.add(new ExampleItem("Include / Merge", 18, 13,
                IncludeLayoutActivity.class, 8));

        items.add(new ExampleItem("Padding", 19, 13,
                PaddingLayoutActivity.class, 8));

        items.add(new ExampleItem("Gradient", 20, 14, GradientActivity.class, 8));

        items.add(new ExampleItem("9-Patch", 21, 14, NinePatchActivity.class, 8));

        items.add(new ExampleItem("XML Drawables", 22, 14, XMLActivity.class, 8));

        items.add(new ExampleItem("XML Bitmap Tiling", 23, 14,
                TilingActivity.class, 8));

        items.add(new ExampleItem("Layers Drawables", 24, 14,
                LayersActivity.class, 8));

        items.add(new ExampleItem("Rotate Drawables", 25, 14,
                RotateScaleActivity.class, 8));

        items.add(new ExampleItem("Draw from Code", 26, 14,
                GraphicsFromCodeActivity.class, 8));

        items.add(new ExampleItem("Responsive design example", 27, 16,
                ResponsiveExampleActivity.class, 11));

        items.add(new ExampleItem("Contextueal Action Bar", 28, 18,
                ActionBarExampleActivity.class, 11));

        items.add(new ExampleItem("Dashboard", 29, 19,
                SmashingAndroidUIExamplesActivity.class, 8));

        items.add(new ExampleItem("Tabbed UI", 30, 19,
                TabsExampleActivity.class, 11));

        items.add(new ExampleItem("Expand in Context", 31, 19,
                ExpandInContextActivity.class, 8));
        
    }

}
