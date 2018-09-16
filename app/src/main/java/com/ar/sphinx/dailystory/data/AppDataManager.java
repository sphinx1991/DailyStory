package com.ar.sphinx.dailystory.data;

import android.content.Context;

import com.ar.sphinx.dailystory.data.model.api.NewsResponse;
import com.ar.sphinx.dailystory.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by sphinx.ar on 15/09/18.
 */
@Singleton
public class AppDataManager implements DataManager {

	private Context context;
	private ApiHelper apiHelper;

	@Inject
	public AppDataManager(Context context, ApiHelper apiHelper) {
		this.context = context;
		this.apiHelper = apiHelper;
	}

	@Override
	public Single<NewsResponse> doNytTrendingApiCall() {
		return apiHelper.doNytTrendingApiCall();
	}

	@Override
	public Single<NewsResponse> doNytRecentApiCall() {
		return apiHelper.doNytRecentApiCall();
	}

	@Override
	public Single<NewsResponse> doCnnTrendingApiCall() {
		return apiHelper.doCnnTrendingApiCall();
	}

	@Override
	public Single<NewsResponse> doCnnRecentApiCall() {
		return apiHelper.doCnnRecentApiCall();
	}

	@Override
	public Single<NewsResponse> doBbcTrendingApiCall() {
		return apiHelper.doBbcTrendingApiCall();
	}

	@Override
	public Single<NewsResponse> doBbcRecentApiCall() {
		return apiHelper.doBbcRecentApiCall();
	}
}
