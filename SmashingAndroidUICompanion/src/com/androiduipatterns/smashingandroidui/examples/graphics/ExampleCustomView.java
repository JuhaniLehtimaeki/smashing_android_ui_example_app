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
package com.androiduipatterns.smashingandroidui.examples.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ExampleCustomView extends View {

    private Paint paint;

    private int x = 0;
    private int y = 0;

    private int width = 200;
    private int height = 200;

    public ExampleCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        // this Paint object is needed every time onDraw is called
        // therefore I create it here and keep it.
        paint = new Paint();
        paint.setColor(0x44FF0000);

        // To demonstrate dynamic drawing I've added a touch listener
        // that allows user to drag the drawn rectange on screen:
        this.setOnTouchListener(new OnTouchListener() {
            int x_start = 0;
            int y_start = 0;

            int x_drag_start = 0;
            int y_drag_start = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    x_drag_start = (int) event.getX();
                    y_drag_start = (int) event.getY();
                    x_start = x;
                    y_start = y;
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    int delta_x = (int) event.getX() - x_drag_start;
                    int delta_y = (int) event.getY() - y_drag_start;
                    x = x_start + delta_x;
                    y = y_start + delta_y;
                    
                    //calling invalidate causes the component to draw itself
                    invalidate();
                }

                return true;
            }
        });

    }

  
    /**
     * Draws a rectangle on screen where the user has dragged it.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(x, y, x + width, y + height, paint);
    }
}
