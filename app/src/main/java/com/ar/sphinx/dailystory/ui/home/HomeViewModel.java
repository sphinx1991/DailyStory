package com.ar.sphinx.dailystory.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableBoolean;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

import java.util.List;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class HomeViewModel extends BaseViewModel<HomeNavigator> {

	private MutableLiveData<List<Article>> trendingList;
	private MutableLiveData<List<Article>> topList;

	public HomeViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}

	public void getTrendingNews() {
		setIsLoading(true);
		getCompositeDisposable().add(getDataManager().doNytTopApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse -> {
							trendingList.setValue(newsResponse.articles());
							setIsLoading(false);
						}
				));
	}

	public void getTopNews() {
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

	public MutableLiveData<List<Article>> getTrendingList() {
		if( trendingList == null){
			trendingList = new MutableLiveData<>();
			getTrendingNews();
		}
		return trendingList;
	}

	public MutableLiveData<List<Article>> getTopList() {
		if( topList == null){
			topList = new MutableLiveData<>();
			getTopNews();
		}
		return topList;
	}
}
