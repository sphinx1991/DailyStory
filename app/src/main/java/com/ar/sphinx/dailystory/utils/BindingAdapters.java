package com.ar.sphinx.dailystory.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

/**
 * Created by sphinx.ar on 16/09/18.
 */
//Data binding adapters
public class BindingAdapters {

	//for loading image from a url to view
	@BindingAdapter({"loadUrlImage"})
	public static void setImageView(ImageView imageView,String url) {
		Glide.with(imageView.getContext()).load(url)
				.into(imageView);
	}
}
