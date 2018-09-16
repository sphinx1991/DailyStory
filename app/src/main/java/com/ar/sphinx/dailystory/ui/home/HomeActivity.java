package com.ar.sphinx.dailystory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityHomeBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.todaynews.top.TopNewsListAdapter;
import com.ar.sphinx.dailystory.ui.home.todaynews.trending.TrendingNewsListAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sphinx.ar on 15/09/18.
 */
//Home screen / main screen where first responses are shown and user can interact.
public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements HomeNavigator {

	@Inject
	HomeViewModel homeViewModel;

	//usage of butter knife
	@BindView(R.id.spinner)
	Spinner spinner;

	@BindView(R.id.drawerLayout)
	DrawerLayout drawerLayout;

	@BindView(R.id.nv)
	NavigationView navigationView;

	@BindView(R.id.toolbarHome)
	Toolbar toolbar;
	ActionBarDrawerToggle actionBarDrawerToggle;


	private TrendingNewsListAdapter trendingNewsListAdapter = new TrendingNewsListAdapter();
	private TopNewsListAdapter topNewsListAdapter = new TopNewsListAdapter();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open, R.string.Close);
		drawerLayout.addDrawerListener(actionBarDrawerToggle);
		actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
		actionBarDrawerToggle.syncState();
		navigationView.bringToFront();
		navigationView.setNavigationItemSelectedListener(item -> {
			int id = item.getItemId();
			switch(id)
			{
				case R.id.exit:
					finish();
					return true;
				default:
					drawerLayout.closeDrawer(GravityCompat.START);
					return true;
			}
		});

		ActivityHomeBinding binding = getViewDataBinding();
		//today trending news adapter
		binding.rvTrending.setAdapter(trendingNewsListAdapter);
		binding.rvTrending.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.HORIZONTAL,false));

		//today top news adapter
		binding.rvToday.setAdapter(topNewsListAdapter);
		binding.rvToday.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL,false));

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				if(position == 0) {
					homeViewModel.getNYTTrendingNews();
					homeViewModel.getNYTRecentNews();
				}else if(position == 1) {
					homeViewModel.getCNNTrendingNews();
					homeViewModel.getCNNRecentNews();
				}else {
					homeViewModel.getBBCTrendingNews();
					homeViewModel.getBBCRecentNews();
				}
			}
			public void onNothingSelected(AdapterView<?> parent) { }
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				drawerLayout.openDrawer(GravityCompat.START);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
