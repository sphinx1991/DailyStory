package com.ar.sphinx.dailystory.utils;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by sphinx.ar on 15/09/18.
 */
@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory {

	public static TypeAdapterFactory create() {
		return new AutoValueGson_AutoValueGsonFactory();
	}
}
