package com.ar.sphinx.dailystory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityHomeBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements HomeNavigator {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Inject
	HomeViewModel homeViewModel;

	@Override
	public int getBindingVariable() {
		return BR.homeViewModel;
	}

	@Override
	public HomeViewModel getViewModel() {
		return homeViewModel;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_home;
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, HomeActivity.class);
	}
}
