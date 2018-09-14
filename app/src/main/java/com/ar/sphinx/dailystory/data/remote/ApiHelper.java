package com.ar.sphinx.dailystory.data.remote;

import com.ar.sphinx.dailystory.data.model.api.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by sphinx.ar on 14/09/18.
 */
// all calls related to api
public interface ApiHelper {

	@GET(ApiEndPoint.ENDPOINT_TOP_NYT)
	Single<NewsResponse> doNytTopApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_NYT)
	Single<NewsResponse> doNytRecentApiCall();

	@GET(ApiEndPoint.ENDPOINT_TOP_CNN)
	Single<NewsResponse> doCnnTopApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_CNN)
	Single<NewsResponse> doCnnRecentApiCall();

	@GET(ApiEndPoint.ENDPOINT_TOP_BBC)
	Single<NewsResponse> doBbcTopApiCall();

	@GET(ApiEndPoint.ENDPOINT_RECENT_BBC)
	Single<NewsResponse> doBbcRecentApiCall();

}
