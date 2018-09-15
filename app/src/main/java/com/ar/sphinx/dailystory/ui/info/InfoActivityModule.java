package com.ar.sphinx.dailystory.ui.info;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sphinx.ar on 16/09/18.
 */
@Module
public class InfoActivityModule {

	@Provides
	InfoViewModel provideSplashViewModel(DataManager dataManager,
	                                       AppSchedulerProvider schedulerProvider) {
		return new InfoViewModel(dataManager, schedulerProvider);
	}
}
