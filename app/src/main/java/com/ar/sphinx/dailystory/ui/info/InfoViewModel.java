package com.ar.sphinx.dailystory.ui.info;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

/**
 * Created by sphinx.ar on 16/09/18.
 */
public class InfoViewModel extends BaseViewModel<InfoNavigator> {

	public InfoViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}
}
