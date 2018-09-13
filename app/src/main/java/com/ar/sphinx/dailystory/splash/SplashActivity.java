package com.ar.sphinx.dailystory.splash;


import com.ar.sphinx.dailystory.BR;
import com.ar.sphinx.dailystory.R;
import com.ar.sphinx.dailystory.base.BaseActivity;
import com.ar.sphinx.dailystory.databinding.ActivitySplashBinding;

/**
 * Created by sphinx.ar on 14/09/18.
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {

	@Override
	public int getBindingVariable() {
		return BR.splashViewModel;
	}

	@Override
	public SplashViewModel getViewModel() {
		return null;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_splash;
	}

	@Override
	public void openMainActivity() {

	}
}
