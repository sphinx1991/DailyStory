package com.ar.sphinx.dailystory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityHomeBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.trending.TrendingNewsListAdapter;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements HomeNavigator {

	@Inject
	HomeViewModel homeViewModel;

	private TrendingNewsListAdapter trendingNewsListAdapter = new TrendingNewsListAdapter();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityHomeBinding binding = getViewDataBinding();
		homeViewModel.setNavigator(this);
		subscribeToLiveData();

		//trending news adapter
		binding.rvTrending.setAdapter(trendingNewsListAdapter);
		binding.rvTrending.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

	}

	private void subscribeToLiveData() {
		homeViewModel.getTrendingList().observe(this, articles -> trendingNewsListAdapter.setNewsList(articles));
	}

	@Override
	public int getBindingVariable() {
		return BR.homeViewModel;
	}

	@Override
	public HomeViewModel getViewModel() {
		return homeViewModel;
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_home;
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, HomeActivity.class);
	}
}
