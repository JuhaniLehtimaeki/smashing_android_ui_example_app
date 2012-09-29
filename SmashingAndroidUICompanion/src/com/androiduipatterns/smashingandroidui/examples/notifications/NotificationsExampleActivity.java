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
package com.androiduipatterns.smashingandroidui.examples.notifications;

import com.androiduipatterns.smashingandroidui.examples.R;

import android.os.Bundle;
import android.view.View;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;

@TargetApi(16)
public class NotificationsExampleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_example);
    }

    public void basicNotification(View view) {
        Notification notification = new Notification.Builder(this)
                .setContentTitle("Basic Notification")
                .setContentText("Basic Notification, used earlier")
                .setSmallIcon(android.R.drawable.ic_lock_silent_mode).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    public void bigTextStyleNotification(View view) {
        String msgText = "Jeally Bean Notification example!! "
                + "where you will see three different kind of notification. "
                + "you can even put the very long string here.";

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent pi = getPendingIntent();
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Big text Notofication")
                .setContentText("Big text Notification")
                .setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_HIGH)
                .addAction(android.R.drawable.ic_lock_silent_mode,
                        "show activity", pi);
        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(msgText).build();

        notificationManager.notify(0, notification);
    }

    public void bigPictureStyleNotification(View view) {
        PendingIntent pi = getPendingIntent();
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("BP notification")
                .setContentText("BigPicutre notification")
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(android.R.drawable.ic_lock_silent_mode,
                        "show activity", pi)
                .addAction(
                        android.R.drawable.ic_input_add,
                        "Share",
                        PendingIntent.getActivity(getApplicationContext(), 0,
                                getIntent(), 0, null));

        Notification notification = new Notification.BigPictureStyle(builder)
                .bigPicture(
                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.example_triangle)).build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    public void inboxStyleNotification(View view) {
        PendingIntent pendingIntentFirst = getPendingIntent();
        PendingIntent pendingIntentSecond = getPendingIntent();
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Inbox Style")
                .setContentText("This is a inbox Style notification")
                .setSmallIcon(R.drawable.ic_launcher)
                .addAction(android.R.drawable.ic_dialog_dialer, "first action",
                        pendingIntentFirst)
                .addAction(android.R.drawable.ic_delete, "second action",
                        pendingIntentSecond);

        Notification notification = new Notification.InboxStyle(builder)
                .addLine("First message").addLine("Second message")
                .addLine("Thrid message").setSummaryText("+5 more messages")
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    public PendingIntent getPendingIntent() {
        return PendingIntent.getActivity(this, 0, new Intent(this,
                NotificationsExampleActivity.class), 0);
    }

}
