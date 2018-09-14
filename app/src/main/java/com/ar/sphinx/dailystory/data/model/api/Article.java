package com.ar.sphinx.dailystory.data.model.api;

import com.google.auto.value.AutoValue;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//data class for single news article
@AutoValue
public abstract class Article {

	abstract String author();
	abstract String title();
	abstract String description();
	abstract String url();
	abstract String publishedAt();
	abstract String content();

	//Builder
	static Builder builder() {
		return new AutoValue_Article.Builder();
	}

	@AutoValue.Builder
	abstract static class Builder {
		abstract Builder setAuthor(String value);
		abstract Builder setTitle(String value);
		abstract Builder setDescription(String value);
		abstract Builder setUrl(String value);
		abstract Builder setPublishedAt(String value);
		abstract Builder setContent(String value);
		abstract Article build();
	}

}
