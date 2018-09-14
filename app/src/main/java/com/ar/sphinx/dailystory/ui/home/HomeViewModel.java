package com.ar.sphinx.dailystory.ui.home;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class HomeViewModel extends BaseViewModel<HomeNavigator> {

	public HomeViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}
}
