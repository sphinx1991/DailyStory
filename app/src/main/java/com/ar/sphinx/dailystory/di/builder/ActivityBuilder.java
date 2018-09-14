package com.ar.sphinx.dailystory.di.builder;

import com.ar.sphinx.dailystory.ui.home.HomeActivity;
import com.ar.sphinx.dailystory.ui.home.HomeActivityModule;
import com.ar.sphinx.dailystory.ui.splash.SplashActivity;
import com.ar.sphinx.dailystory.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by sphinx.ar on 13/09/18.
 */
@Module
public abstract class ActivityBuilder {

	@ContributesAndroidInjector(modules = SplashActivityModule.class)
	abstract SplashActivity splashActivity();

	@ContributesAndroidInjector(modules = HomeActivityModule.class)
	abstract HomeActivity homeActivity();



}
