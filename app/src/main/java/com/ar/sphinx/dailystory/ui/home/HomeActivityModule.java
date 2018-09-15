package com.ar.sphinx.dailystory.ui.home;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sphinx.ar on 15/09/18.
 */
@Module
public class HomeActivityModule {

	@Provides
	HomeViewModel provideHomeViewModel(DataManager dataManager,
	                                   AppSchedulerProvider schedulerProvider) {
		return new HomeViewModel(dataManager, schedulerProvider);
	}
}
