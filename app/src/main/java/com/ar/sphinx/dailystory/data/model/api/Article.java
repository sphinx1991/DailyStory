package com.ar.sphinx.dailystory.data.model.api;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//data class for single news article
@AutoValue
public abstract class Article {

	@Nullable
	public abstract String author();
	@Nullable
	public abstract String title();
	@Nullable
	public abstract String description();
	@Nullable
	public abstract String url();
	@Nullable
	public abstract String publishedAt();
	@Nullable
	public abstract String content();
	@Nullable
	public abstract String urlToImage();

	public static TypeAdapter<Article> typeAdapter(Gson gson) {
		return new AutoValue_Article.GsonTypeAdapter(gson);
	}
}
