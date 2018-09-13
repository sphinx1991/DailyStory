package com.ar.sphinx.dailystory.di.module;

import com.ar.sphinx.dailystory.BuildConfig;
import com.ar.sphinx.dailystory.data.remote.GetNewsApi;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Named;
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

//	@Named("NYTAPI")
	@Provides
	@Singleton
	GetNewsApi getNewsApi(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
	                      GsonConverterFactory gsonConverterFactory,
	                      OkHttpClient okHttpClient) {
		return new Retrofit.Builder()
				.addCallAdapterFactory(rxJava2CallAdapterFactory)
				.addConverterFactory(gsonConverterFactory)
				.client(okHttpClient)
				.build()
				.create(GetNewsApi.class);
	}

//	@Named("CNNAPI")
//	@Provides
//	@Singleton
//	GetNewsApi getCNNNewsApi(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
//	                      GsonConverterFactory gsonConverterFactory,
//	                      OkHttpClient okHttpClient) {
//		return new Retrofit.Builder()
//				.addCallAdapterFactory(rxJava2CallAdapterFactory)
//				.addConverterFactory(gsonConverterFactory)
//				.client(okHttpClient)
//				.baseUrl(BuildConfig.CNN_BASE_URL)
//				.build()
//				.create(GetNewsApi.class);
//	}
//
//	@Named("BBCAPI")
//	@Provides
//	@Singleton
//	GetNewsApi getBBCNewsApi(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
//	                      GsonConverterFactory gsonConverterFactory,
//	                      OkHttpClient okHttpClient) {
//		return new Retrofit.Builder()
//				.addCallAdapterFactory(rxJava2CallAdapterFactory)
//				.addConverterFactory(gsonConverterFactory)
//				.client(okHttpClient)
//				.baseUrl(BuildConfig.BBC_BASE_URL)
//				.build()
//				.create(GetNewsApi.class);
//	}

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