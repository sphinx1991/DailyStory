package com.ar.sphinx.dailystory.di.module;

import android.content.Context;

import com.ar.sphinx.dailystory.DailyStoryApp;
import com.ar.sphinx.dailystory.data.AppDataManager;
import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;

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
	Context provideContext(DailyStoryApp application) {
		return application;
	}

	@Provides
	AppSchedulerProvider provideSchedulerProvider() {
		return new AppSchedulerProvider();
	}

	@Provides
	@Singleton
	DataManager provideDataManager(AppDataManager appDataManager) {
		return appDataManager;
	}

	//to be used when different api key are available
	/*
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
	*/
}
