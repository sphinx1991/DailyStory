package com.ar.sphinx.dailystory.ui.home.trending;

import android.databinding.ObservableField;

import com.ar.sphinx.dailystory.data.model.api.Article;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class TrendingViewModel {

	public ObservableField<String> heading = new ObservableField<>();
	public ObservableField<String> date = new ObservableField<>();

	public TrendingViewModel(Article article) {
		this.heading.set(article.title());
		this.date.set(article.publishedAt());
	}

}
