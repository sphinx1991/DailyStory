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
public class HomeViewModel extends BaseViewModel<HomeNavigator> {

	private final MutableLiveData<List<Article>> trendingList;

	public HomeViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
		trendingList = new MutableLiveData<>();
		getTrendingNews();
	}

	public void getTrendingNews() {
		getCompositeDisposable().add(getDataManager().doNytTopApiCall()
				.subscribeOn(getSchedulerProvider().io())
				.observeOn(getSchedulerProvider().ui())
				.subscribe(newsResponse ->
					trendingList.setValue(newsResponse.articles())
				));
	}

	public MutableLiveData<List<Article>> getTrendingList() {
		return trendingList;
	}
}
