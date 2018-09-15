package com.ar.sphinx.dailystory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityHomeBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.todaynews.top.TopNewsListAdapter;
import com.ar.sphinx.dailystory.ui.home.todaynews.trending.TrendingNewsListAdapter;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements HomeNavigator {

	@Inject
	HomeViewModel homeViewModel;

	private TrendingNewsListAdapter trendingNewsListAdapter = new TrendingNewsListAdapter();
	private TopNewsListAdapter topNewsListAdapter = new TopNewsListAdapter();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		homeViewModel.setNavigator(this);
		subscribeToLiveData();
		setUpViews();
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

	private void subscribeToLiveData() {
		homeViewModel.getTrendingList().observe(this, articles -> {
			trendingNewsListAdapter.setNewsList(articles);
			getViewDataBinding().rvTrending.scrollToPosition(0);
		});
		homeViewModel.getTopList().observe(this, articles -> {
			topNewsListAdapter.setNewsList(articles);
			getViewDataBinding().rvToday.scrollToPosition(0);
		});

	}

	public void setUpViews() {
		ActivityHomeBinding binding = getViewDataBinding();
		//today trending news adapter
		binding.rvTrending.setAdapter(trendingNewsListAdapter);
		binding.rvTrending.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.HORIZONTAL,false));

		//today top news adapter
		binding.rvToday.setAdapter(topNewsListAdapter);
		binding.rvToday.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL,false));

		binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				if(position == 0) {
					homeViewModel.getNYTTrendingNews();
					homeViewModel.getNYTTopNews();
				}else if(position == 1) {
					homeViewModel.getCNNTrendingNews();
					homeViewModel.getCNNTopNews();
				}else {
					homeViewModel.getBBCTrendingNews();
					homeViewModel.getBBCTopNews();
				}
			}
			public void onNothingSelected(AdapterView<?> parent) { }
		});
	}
}
