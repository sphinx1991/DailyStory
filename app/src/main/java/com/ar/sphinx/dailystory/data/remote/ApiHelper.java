package com.ar.sphinx.dailystory.data.remote;

import com.ar.sphinx.dailystory.data.model.api.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by sphinx.ar on 14/09/18.
 */
// all calls related to api
public interface ApiHelper {

	@GET(ApiEndPoint.ENDPOINT_TRENDING_NYT)
	Single<NewsResponse> doNytTrendingApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_NYT)
	Single<NewsResponse> doNytRecentApiCall();

	@GET(ApiEndPoint.ENDPOINT_TRENDING_CNN)
	Single<NewsResponse> doCnnTrendingApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_CNN)
	Single<NewsResponse> doCnnRecentApiCall();

	@GET(ApiEndPoint.ENDPOINT_TRENDING_BBC)
	Single<NewsResponse> doBbcTrendingApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_BBC)
	Single<NewsResponse> doBbcRecentApiCall();

}
