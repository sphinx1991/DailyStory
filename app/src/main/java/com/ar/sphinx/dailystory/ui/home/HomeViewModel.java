package com.ar.sphinx.dailystory.ui.home;

import android.arch.lifecycle.MutableLiveData;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

import java.util.List;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//viewmodel class for home screen interacting with data for home views
public class HomeViewModel extends BaseViewModel<HomeNavigator> {

	//mutable live arch component used to give latest changes in home activity when data changes.
	private MutableLiveData<List<Article>> trendingList;
	private MutableLiveData<List<Article>> topList;

	public HomeViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}

	public void getNYTTrendingNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doNytTrendingApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							trendingList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getNYTRecentNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doNytRecentApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							topList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getCNNTrendingNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doCnnTrendingApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							trendingList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getCNNRecentNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doCnnRecentApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							topList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getBBCTrendingNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doBbcTrendingApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							trendingList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getBBCRecentNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doBbcRecentApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							topList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public MutableLiveData<List<Article>> getTrendingList() {
		if( trendingList == null){
			trendingList = new MutableLiveData<>();
			getNYTRecentNews();
		}
		return trendingList;
	}

	public MutableLiveData<List<Article>> getTopList() {
		if( topList == null){
			topList = new MutableLiveData<>();
			getNYTRecentNews();
		}
		return topList;
	}
}
