package com.ar.sphinx.dailystory.ui.splash;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.databinding.ActivitySplashBinding;
import com.ar.sphinx.dailystory.ui.base.BaseActivity;
import com.ar.sphinx.dailystory.ui.home.HomeActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

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

		checkForNavigation();
	}

	private void checkForNavigation() {
		splashViewModel.getCompositeDisposable().add(Observable.timer(2000, TimeUnit.MILLISECONDS)
				.subscribeOn(splashViewModel.getSchedulerProvider().io()).repeat()
				.observeOn(AndroidSchedulers.mainThread()).subscribe(aLong -> {
					if(isNetworkpresent()) {
						splashViewModel.decideNextActivity();
					} else {
						Toast.makeText(getApplicationContext(), R.string.net_check, Toast.LENGTH_SHORT).show();
					}
				}));
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

	@Override
	protected void onDestroy() {
		super.onDestroy();
		splashViewModel.getCompositeDisposable().dispose();
	}

	public static Intent getStartIntent(Context context) {
		return new Intent(context, SplashActivity.class);
	}
}
