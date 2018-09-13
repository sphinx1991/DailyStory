package com.ar.sphinx.dailystory.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sphinx.ar on 13/09/18.
 */
// base view model of all view models
public abstract class BaseViewModel<N> extends ViewModel {

//	private N mNavigator;
//	private DataManager dataManager;
//	private SchedulerProvider schedulerProvider;
//	private ObservableBoolean isLoading = new ObservableBoolean(false);
//	private CompositeDisposable compositeDisposable;
//
//	public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
//		this.dataManager = dataManager;
//		this.schedulerProvider = schedulerProvider;
//		this.compositeDisposable = new CompositeDisposable();
//	}
//
//	public N getNavigator() {
//		return mNavigator;
//	}
//
//	public void setNavigator(N mNavigator) {
//		this.mNavigator = mNavigator;
//	}
//
//	public DataManager getDataManager() {
//		return dataManager;
//	}
//
//	public void setDataManager(DataManager mDataManager) {
//		this.dataManager = mDataManager;
//	}
//
//	public SchedulerProvider getSchedulerProvider() {
//		return schedulerProvider;
//	}
//
//	public void setSchedulerProvider(SchedulerProvider mSchedulerProvider) {
//		this.schedulerProvider = mSchedulerProvider;
//	}
//
//	public ObservableBoolean getIsLoading() {
//		return isLoading;
//	}
//
//	public void setIsLoading(ObservableBoolean mIsLoading) {
//		this.isLoading = mIsLoading;
//	}
//
//	public CompositeDisposable getCompositeDisposable() {
//		return compositeDisposable;
//	}
//
//	public void setCompositeDisposable(CompositeDisposable mCompositeDisposable) {
//		this.compositeDisposable = mCompositeDisposable;
//	}
//
//	@Override
//	protected void onCleared() {
//		super.onCleared();
//		compositeDisposable.dispose();
//
//	}
}
