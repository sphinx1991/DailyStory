package com.ar.sphinx.dailystory.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sphinx.ar on 14/09/18.
 */
public final class CommonUtils {

	private CommonUtils() { }

	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm =
				(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = null;
		if(cm != null) {
			activeNetwork = cm.getActiveNetworkInfo();
		}
		return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
	}
}
