package com.ar.sphinx.dailystory.ui.splash;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

/**
 * Created by sphinx.ar on 14/09/18.
 */
public class SplashViewModel extends BaseViewModel<SplashNavigator> {

	public SplashViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}

	public void decideNextActivity() {
			getNavigator().openHomeActivity();
	}
}
