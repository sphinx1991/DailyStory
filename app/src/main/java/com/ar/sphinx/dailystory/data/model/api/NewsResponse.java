package com.ar.sphinx.dailystory.data.model.api;

import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//data class for all news response implemented using AutoValue by google
@AutoValue
public abstract class NewsResponse {

	abstract String status();
	abstract int totalResults();
	abstract List<Article> articles();

	//Builder
	static NewsResponse.Builder builder() {
		return new AutoValue_NewsResponse.Builder();
	}

	@AutoValue.Builder
	abstract static class Builder {
		abstract NewsResponse.Builder setStatus(String value);
		abstract NewsResponse.Builder setTotalResults(int value);
		abstract NewsResponse.Builder setArticles(List<Article> value);
		abstract NewsResponse build();
	}

}


