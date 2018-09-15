package com.ar.sphinx.dailystory.ui.info;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivityInfoBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.HomeActivity;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 16/09/18.
 */
public class InfoActivity extends BaseActivity<ActivityInfoBinding,InfoViewModel> implements InfoNavigator {

	@Inject
	InfoViewModel infoViewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		infoViewModel.setNavigator(this);
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

	public static Intent getStartIntent(Context context) {
		return new Intent(context, InfoActivity.class);
	}
}
