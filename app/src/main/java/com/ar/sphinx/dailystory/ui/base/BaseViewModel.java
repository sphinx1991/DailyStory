package com.ar.sphinx.dailystory.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sphinx.ar on 13/09/18.
 */
// base view model of all view models
public abstract class BaseViewModel<N> extends ViewModel {

	//navigator to start activities from each other
	private N mNavigator;
	private DataManager dataManager;
	private AppSchedulerProvider schedulerProvider;
	private ObservableBoolean isLoading = new ObservableBoolean(false);
	private CompositeDisposable compositeDisposable;

	public BaseViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		this.dataManager = dataManager;
		this.schedulerProvider = schedulerProvider;
		this.compositeDisposable = new CompositeDisposable();
	}

	public N getNavigator() {
		return mNavigator;
	}

	public void setNavigator(N mNavigator) {
		this.mNavigator = mNavigator;
	}

	public DataManager getDataManager() {
		return dataManager;
	}


	public AppSchedulerProvider getSchedulerProvider() {
		return schedulerProvider;
	}

	public ObservableBoolean getIsLoading() {
		return isLoading;
	}

	public void setIsLoading(boolean mIsLoading) {
		isLoading.set(mIsLoading);
	}

	public CompositeDisposable getCompositeDisposable() {
		return compositeDisposable;
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		compositeDisposable.dispose();
	}
}
