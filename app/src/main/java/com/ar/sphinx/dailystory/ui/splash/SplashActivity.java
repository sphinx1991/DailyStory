package com.ar.sphinx.dailystory.ui.splash;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivitySplashBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.HomeActivity;

import javax.inject.Inject;

/**
 * Created by sphinx.ar on 14/09/18.
 */
//splash screen which is first view shown when app opens, show loading basically and redirects to next act.
public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {

	@Inject
	SplashViewModel splashViewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		splashViewModel.setNavigator(this);
		requestPermissionsSafely(new String[]{Manifest.permission.INTERNET,
						Manifest.permission.ACCESS_NETWORK_STATE},
				123);
		new Handler().postDelayed(() -> {
			splashViewModel.decideNextActivity();
		},3000);
	}

	@Override
	public int getBindingVariable() {
		return BR.splashViewModel;
	}

	@Override
	public SplashViewModel getViewModel() {
		return splashViewModel;
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_splash;
	}

	@Override
	public void openHomeActivity() {
		Intent intent = HomeActivity.getStartIntent(SplashActivity.this);
		startActivity(intent);
		finish();
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, SplashActivity.class);
	}
}
