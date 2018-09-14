package com.ar.sphinx.dailystory.rxproviders;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class AppSchedulerProvider {

	public Scheduler ui() {
		return AndroidSchedulers.mainThread();
	}

	public Scheduler computation() {
		return Schedulers.computation();
	}

	public Scheduler io() {
		return Schedulers.io();
	}
}
