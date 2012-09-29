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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.androiduipatterns.smashingandroidui.examples.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExamplesListAdapter extends BaseAdapter {
	private final Context context;
	private List<ExampleItem> items;

	private final Map<View, Map<Integer, View>> cache = new HashMap<View, Map<Integer, View>>();

	public ExamplesListAdapter(Context context, List<ExampleItem> items) {
		this.context = context;
		this.items = items;
	}

	public void setItems(List<ExampleItem> items) {
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return ((ExampleItem)getItem(position)).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		TextView titleTextView;
		TextView sdklevelTextView;
		TextView chapterTextView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.example_list_item, parent, false);
		}
		Map<Integer, View> itemMap = cache.get(v);
		if (itemMap == null) {
			itemMap = new HashMap<Integer, View>();
			titleTextView = (TextView) v.findViewById(R.id.example_item_title);
			sdklevelTextView = (TextView) v.findViewById(R.id.example_item_minsdk);
			chapterTextView = (TextView) v.findViewById(R.id.example_item_chapter);
			
			
			itemMap.put(R.id.example_item_title, titleTextView);
			itemMap.put(R.id.example_item_minsdk, sdklevelTextView);
			itemMap.put(R.id.example_item_chapter, chapterTextView);
            
			
			cache.put(v, itemMap);
		} else {
			titleTextView = (TextView) itemMap.get(R.id.example_item_title);
			sdklevelTextView = (TextView) itemMap.get(R.id.example_item_minsdk);
			chapterTextView = (TextView) itemMap.get(R.id.example_item_chapter);
		}

		
		ExampleItem item = (ExampleItem) getItem(position);
		
		titleTextView.setText(item.getTitle());
		sdklevelTextView.setText("min SDK " +item.getMinAPILevel());
		chapterTextView.setText("chapter " + item.getChapter());

		
		if(item.getMinAPILevel() > android.os.Build.VERSION.SDK_INT){
		    sdklevelTextView.setVisibility(View.VISIBLE);
		}else{
		    sdklevelTextView.setVisibility(View.GONE);
		}
		    
		
		
		return v;
	}
}
