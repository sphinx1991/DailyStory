package com.ar.sphinx.dailystory.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import dagger.android.AndroidInjection;

/**
 * Created by sphinx.ar on 13/09/18.
 */
public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel> extends AppCompatActivity {

	//Progress bar used for all screens
	private ProgressDialog mProgressDialog;

	//data binding and view model of each activity
	private T mViewDataBinding;
	private V mViewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		performDependencyInjection();
		super.onCreate(savedInstanceState);
		performDataBinding();
	}

	private void performDataBinding() {
		mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
		mViewModel = mViewModel == null ? getViewModel() : mViewModel;
		mViewDataBinding.setVariable(getBindingVariable(),mViewModel);
		mViewDataBinding.executePendingBindings();
	}

	public void hideLoading() {
		if( mProgressDialog!= null && mProgressDialog.isShowing()) {
			mProgressDialog.cancel();
		}
	}

	public void showLoading() {
		hideLoading();
		//todo show loading dialog from utils
	}

	public void hideKeyboard() {
		View view = this.getCurrentFocus();
		if(view != null) {
			InputMethodManager inputManager =
					(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			if(inputManager != null) {
				inputManager.hideSoftInputFromWindow(view.getWindowToken(),0);
			}
		}
	}

	public boolean isNetworkpresent() {
		//todo from utils class
		//for now
		return true;
	}

	@TargetApi(Build.VERSION_CODES.M)
	public void requestPermissionsSafely(String[] permissions, int requestCode) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			requestPermissions(permissions, requestCode);
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	public boolean hasPermission(String permission) {
		return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
				checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	}

	private void performDependencyInjection() {
		AndroidInjection.inject(this);
	}

	protected abstract int getBindingVariable();

	protected abstract V getViewModel();

	@LayoutRes
	protected abstract int getLayoutId();


}
