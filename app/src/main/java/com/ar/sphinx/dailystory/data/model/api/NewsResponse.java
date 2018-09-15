package com.ar.sphinx.dailystory.data.model.api;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//data class for all news response implemented using AutoValue by google
@AutoValue
public abstract class NewsResponse {

	public abstract String status();
	public abstract int totalResults();
	public abstract List<Article> articles();

	public static TypeAdapter<NewsResponse> typeAdapter(Gson gson) {
		return new AutoValue_NewsResponse.GsonTypeAdapter(gson);
	}
}


