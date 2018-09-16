package com.ar.sphinx.dailystory.ui.splash;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//DI module for splash screen
@Module
public class SplashActivityModule {

	@Provides
	SplashViewModel provideSplashViewModel(DataManager dataManager,
	                                       AppSchedulerProvider schedulerProvider) {
		return new SplashViewModel(dataManager, schedulerProvider);
	}
}
