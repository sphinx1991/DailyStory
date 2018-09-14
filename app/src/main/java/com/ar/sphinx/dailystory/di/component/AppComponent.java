package com.ar.sphinx.dailystory.di.component;

import com.ar.sphinx.dailystory.DailyStoryApp;
import com.ar.sphinx.dailystory.di.builder.ActivityBuilder;
import com.ar.sphinx.dailystory.di.module.AppModule;
import com.ar.sphinx.dailystory.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by sphinx.ar on 14/09/18.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, NetworkModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DailyStoryApp> {

	@Component.Builder
	abstract class Builder extends AndroidInjector.Builder<DailyStoryApp>{}
}
