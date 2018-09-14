package com.ar.sphinx.dailystory.di.module;

import com.ar.sphinx.dailystory.BuildConfig;
import com.ar.sphinx.dailystory.data.remote.ApiHelper;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sphinx.ar on 13/09/18.
 */
@Module
public class NetworkModule {

	@Provides
	@Singleton
	ApiHelper getNewsApi(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
	                     GsonConverterFactory gsonConverterFactory,
	                     OkHttpClient okHttpClient) {
		return new Retrofit.Builder()
				.addCallAdapterFactory(rxJava2CallAdapterFactory)
				.addConverterFactory(gsonConverterFactory)
				.client(okHttpClient)
				.baseUrl(BuildConfig.BASE_URL)
				.build()
				.create(ApiHelper.class);
	}

	@Provides
	@Singleton
	GsonConverterFactory gsonConverterFactory() {
		return GsonConverterFactory.create();
	}

	@Provides
	@Singleton
	RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
		return RxJava2CallAdapterFactory.create();
	}

	@Provides
	@Singleton
	OkHttpClient okHttpClient(StethoInterceptor stethoInterceptor) {
		return new OkHttpClient.Builder()
				.addNetworkInterceptor(stethoInterceptor)
				.build();
	}

	@Provides
	@Singleton
	StethoInterceptor stethoInterceptor() {
		return new StethoInterceptor();
	}



}
