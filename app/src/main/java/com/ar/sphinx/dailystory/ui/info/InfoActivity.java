package com.ar.sphinx.dailystory.ui.info;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityInfoBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 16/09/18.
 */
//Detail info activity opened from each item of news list. Give details info
public class InfoActivity extends BaseActivity<ActivityInfoBinding,InfoViewModel> implements InfoNavigator {

	@Inject
	InfoViewModel infoViewModel;
	ActivityInfoBinding binding;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = getViewDataBinding();
		setSupportActionBar(binding.toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		infoViewModel.setNavigator(this);
		infoViewModel.setData(getIntent().getStringExtra("article"));
	}

	@Override
	public int getBindingVariable() {
		return BR.infoViewModel;
	}

	@Override
	public InfoViewModel getViewModel() {
		return infoViewModel;
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_info;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, InfoActivity.class);
	}
}
