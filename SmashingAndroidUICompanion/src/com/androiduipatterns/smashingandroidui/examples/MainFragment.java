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
package com.androiduipatterns.smashingandroidui.examples;

import com.actionbarsherlock.app.SherlockFragment;
import com.androiduipatterns.smashingandroidui.examples.example.ExamplesListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.main_fragment, container, false);

		Button examplesButton = (Button) v.findViewById(R.id.button_examples);
		Button linksButton = (Button) v.findViewById(R.id.button_links);
		Button aboutAuthorButton = (Button) v
				.findViewById(R.id.button_about_author);

		examplesButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(getActivity(), ExamplesListActivity.class);
				startActivity(i);
			}
		});

		return v;
	}

}
