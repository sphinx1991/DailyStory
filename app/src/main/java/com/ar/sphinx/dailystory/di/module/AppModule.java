package com.ar.sphinx.dailystory.di.module;

import android.app.Application;
import android.content.Context;

import com.ar.sphinx.dailystory.BuildConfig;
import com.ar.sphinx.dailystory.di.qualifiers.BBCApiInfo;
import com.ar.sphinx.dailystory.di.qualifiers.CNNApiInfo;
import com.ar.sphinx.dailystory.di.qualifiers.NYTApiInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sphinx.ar on 13/09/18.
 */
@Module
public class AppModule {

	@Provides
	@Singleton
	Context provideContext(Application application) {
		return application;
	}

	@Provides
	SchedulerProvider provideSchedulerProvider() {
		return new AppSchedulerProvider();
	}

	@Provides
	@NYTApiInfo
	String provideNYTApiKey() {
		return BuildConfig.NYT_API_KEY;
	}

	@Provides
	@CNNApiInfo
	String provideCNNApiKey() {
		return BuildConfig.CNN_API_KEY;
	}

	@Provides
	@BBCApiInfo
	String provideBBCApiKey() {
		return BuildConfig.BBC_API_KEY;
	}

	@Provides
	@Singleton
	DataManager provideDataManager(AppDataManager appDataManager) {
		return appDataManager;
	}
}
