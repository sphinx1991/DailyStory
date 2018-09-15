package com.ar.sphinx.dailystory.ui.home.todaynews;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class NewsViewModel {

	public ObservableField<String> heading = new ObservableField<>();
	public ObservableField<String> date = new ObservableField<>();
	public ObservableField<String> imgUrl = new ObservableField<>();

	public NewsViewModel(Article article) {
		this.heading.set(article.title());
		this.date.set(article.publishedAt());
		this.imgUrl.set(article.urlToImage());
	}

}
