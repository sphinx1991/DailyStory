package com.ar.sphinx.dailystory.ui.home.trending;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.databinding.LayoutTrendingBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class TrendingNewsListAdapter extends RecyclerView.Adapter<TrendingNewsListAdapter.MyViewHolder>{

	private List<Article> articleList;

	public TrendingNewsListAdapter() {
		this.articleList = Collections.emptyList();
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutTrendingBinding binding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.layout_trending, parent, false);
		return new MyViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		LayoutTrendingBinding trendingBinding = holder.binding;
		trendingBinding.setNewsViewModel(new NewsViewModel(articleList.get(position)));
		trendingBinding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return articleList == null ? 0 : articleList.size();
	}

	public void setNewsList(List<Article> articleList) {
		this.articleList = articleList;
		notifyDataSetChanged();
	}

	class MyViewHolder extends RecyclerView.ViewHolder {

		private LayoutTrendingBinding binding;

		public MyViewHolder(LayoutTrendingBinding itemBinding) {
			super(itemBinding.getRoot());
			this.binding = itemBinding;
		}
	}
}
