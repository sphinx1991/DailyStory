package com.ar.sphinx.dailystory.ui.base;

import android.annotation.TargetApi;
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
import android.widget.ProgressBar;

import com.ar.sphinx.dailystory.utils.CommonUtils;

import dagger.android.AndroidInjection;

/**
 * Created by sphinx.ar on 13/09/18.
 */
//base activity of all classes
public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel> extends AppCompatActivity {

	//Progress bar used for all screens
	private ProgressBar progressBar;

	//data binding and view model of each activity
	private T viewDataBinding;
	private V viewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		performDependencyInjection();
		super.onCreate(savedInstanceState);
		performDataBinding();
	}

	//data binding of activity
	private void performDataBinding() {
		viewDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
		this.viewModel = viewModel == null ? getViewModel() : viewModel;
		viewDataBinding.setVariable(getBindingVariable(), viewModel);
		viewDataBinding.executePendingBindings();
	}

	//adding DI
	private void performDependencyInjection() {
		AndroidInjection.inject(this);
	}

	public void hideLoading() {
		if( progressBar!= null) {
			progressBar.setVisibility(View.GONE);
		}
	}

	//show ProgressBar
	public void showLoading() {
		hideLoading();
		progressBar.setVisibility(View.VISIBLE);
	}

	//hide keyboard
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

	//check for internet connectivity
	public boolean isNetworkpresent() {
		return CommonUtils.isNetworkConnected(getApplicationContext());
	}

	//take permissions
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

	//get variable from each class
	public abstract int getBindingVariable();

	//get viewmodel of each class
	public abstract V getViewModel();

	//get binding
	public T getViewDataBinding() {
		return viewDataBinding;
	}

	//get Layout Id of xml
	@LayoutRes
	public abstract int getLayoutId();


}
