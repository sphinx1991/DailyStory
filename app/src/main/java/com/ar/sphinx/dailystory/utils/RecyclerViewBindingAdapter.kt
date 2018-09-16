package com.ar.sphinx.dailystory.utils

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by sphinx.ar on 15/09/18.
 */
//common recycler binding adapter
abstract class RecyclerViewBindingAdapter<T : ViewDataBinding> :
		RecyclerView.Adapter<RecyclerViewBindingAdapter.BaseViewHolder<T>>() {

	abstract fun onCreateViewBinding(parent: ViewGroup, viewType: Int): T

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
		return BaseViewHolder(onCreateViewBinding(parent, viewType))
	}

	abstract fun onBindView(viewBinding: T, position: Int)

	override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
		onBindView(holder.viewBinding, position)
		holder.viewBinding.executePendingBindings()
	}

	class BaseViewHolder<out T : ViewDataBinding>(val viewBinding: T) : RecyclerView.ViewHolder(viewBinding.root)
}
