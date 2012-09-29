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


public class ExampleItem {

	private String title;
	private int id;
	private int chapter;
	private Class activityToStart;
	private int minAPILevel;

	public ExampleItem(String title, int id, int chapter, Class activityToStart, int minAPILevel) {
		super();
		this.title = title;
		this.id = id;
		this.chapter = chapter;
		this.activityToStart = activityToStart;
		this.minAPILevel = minAPILevel;
	}

	public int getChapter() {
		return chapter;
	}

	public Class getActivityToStart() {
		return activityToStart;
	}

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}
	
	public int getMinAPILevel() {
        return minAPILevel;
    }

}
