package com.ar.sphinx.dailystory.di.component;

import android.app.Application;

import com.ar.sphinx.dailystory.DailyStoryApp;
import com.ar.sphinx.dailystory.di.module.AppModule;
import com.ar.sphinx.dailystory.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by sphinx.ar on 14/09/18.
 */
@Singleton
@Component(modules = {AndroidSupportInjection.class, AppModule.class, NetworkModule.class})
public interface AppComponent {

	@Component.Builder
	interface Builder {

		@BindsInstance
		Builder application(Application application);

		AppComponent build();
	}

	void inject(DailyStoryApp app);
}
