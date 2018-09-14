package com.ar.sphinx.dailystory.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sphinx.ar on 13/09/18.
 */

// base view holder of recyler view holders
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

	public BaseViewHolder(View itemView) {
		super(itemView);
	}

	public abstract void bindHolder(int pos);
}
