package com.ar.sphinx.dailystory.ui.home.todaynews.top;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.databinding.LayoutTodayBinding;
import com.ar.sphinx.dailystory.ui.home.todaynews.NewsViewModel;
import com.ar.sphinx.dailystory.ui.info.InfoActivity;
import com.google.gson.JsonObject;

import java.util.Collections;
import java.util.List;

/**
 * Created by sphinx.ar on 16/09/18.
 */
//today top news view adapter
public class TopNewsListAdapter extends RecyclerView.Adapter<TopNewsListAdapter.MyViewHolder>{

	private List<Article> articleList;

	public TopNewsListAdapter() {
		this.articleList = Collections.emptyList();
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutTodayBinding binding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.layout_today, parent, false);
		return new MyViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		LayoutTodayBinding todayBinding = holder.binding;
		todayBinding.setNewsViewModel(new NewsViewModel(articleList.get(position)));
		todayBinding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return articleList == null ? 0 : articleList.size();
	}

	public void setNewsList(List<Article> articleList) {
		this.articleList = articleList;
		notifyDataSetChanged();
	}

	class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private LayoutTodayBinding binding;

		public MyViewHolder(LayoutTodayBinding itemBinding) {
			super(itemBinding.getRoot());
			itemView.setOnClickListener(this);
			this.binding = itemBinding;
		}

		@Override
		public void onClick(View view) {
			JsonObject data = new JsonObject();
			data.addProperty("heading",articleList.get(getAdapterPosition()).title());
			data.addProperty("date",articleList.get(getAdapterPosition()).publishedAt());
			data.addProperty("imgUrl",articleList.get(getAdapterPosition()).urlToImage());
			data.addProperty("description",articleList.get(getAdapterPosition()).description());
			Intent intent = new Intent(itemView.getContext(), InfoActivity.class);
			intent.putExtra("article",data.toString());
			itemView.getContext().startActivity(intent);
		}
	}
}
