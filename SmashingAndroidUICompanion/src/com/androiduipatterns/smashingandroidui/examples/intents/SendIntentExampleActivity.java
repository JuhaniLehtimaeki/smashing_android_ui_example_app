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
package com.androiduipatterns.smashingandroidui.examples.intents;

import com.actionbarsherlock.app.SherlockActivity;
import com.androiduipatterns.smashingandroidui.examples.R;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendIntentExampleActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle("Send Intent Example");

		setContentView(R.layout.send_intent_example);

		final EditText addressField = (EditText) findViewById(R.id.example_address_field);
		final Button sendIntent = (Button) findViewById(R.id.example_intent_send_button);

		sendIntent.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Uri geoUri = Uri.parse("geo:0,0?q="
						+ addressField.getText().toString());
				Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
				startActivity(mapCall);

			}
		});

	}

}
