package com.ar.sphinx.dailystory;



import com.ar.sphinx.dailystory.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by sphinx.ar on 14/09/18.
 */
//Main entry point to the app
public class DailyStoryApp extends DaggerApplication  {

	@Override
	protected AndroidInjector<DailyStoryApp> applicationInjector() {
		return DaggerAppComponent.builder().create(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}
}
