package com.ar.sphinx.dailystory.data.remote;

import com.ar.sphinx.dailystory.BuildConfig;

/**
 * Created by sphinx.ar on 15/09/18.
 */
// all api endpoints source
public class ApiEndPoint {

	ApiEndPoint(){ }

	public static final String ENDPOINT_TRENDING_NYT = "top-headlines?sources=the-new-york-times&apiKey="+BuildConfig.API_KEY;

	public static final String ENDPOINT_RECENT_NYT = "everything?sources=the-new-york-times&apiKey="+BuildConfig.API_KEY;

	public static final String ENDPOINT_TRENDING_CNN = "top-headlines?sources=cnn&apiKey="+BuildConfig.API_KEY;

	public static final String ENDPOINT_RECENT_CNN = "everything?sources=cnn&apiKey="+BuildConfig.API_KEY;

	public static final String ENDPOINT_TRENDING_BBC = "top-headlines?sources=bbc-news&apiKey="+BuildConfig.API_KEY;

	public static final String ENDPOINT_RECENT_BBC = "everything?sources=bbc-news&apiKey="+BuildConfig.API_KEY;
}
