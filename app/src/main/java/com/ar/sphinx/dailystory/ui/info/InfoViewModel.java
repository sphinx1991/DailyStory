package com.ar.sphinx.dailystory.ui.info;

import android.databinding.ObservableField;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.rxproviders.AppSchedulerProvider;
import com.ar.sphinx.dailystory.ui.base.BaseViewModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by sphinx.ar on 16/09/18.
 */
//view model for info activity binded to view as medium to info model
public class InfoViewModel extends BaseViewModel<InfoNavigator> {

	public InfoViewModel(DataManager dataManager, AppSchedulerProvider schedulerProvider) {
		super(dataManager, schedulerProvider);
	}

	private SimpleDateFormat isoDateFormatOne = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
	private SimpleDateFormat isoDateFormatTwo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
	private SimpleDateFormat readableDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.US);

	public ObservableField<String> heading = new ObservableField<>();
	public ObservableField<String> date = new ObservableField<>();
	public ObservableField<String> imgUrl = new ObservableField<>();
	public ObservableField<String> description = new ObservableField<>();

	public void setData(String data) {
		JsonObject obj = new JsonParser().parse(data).getAsJsonObject();
		heading.set(obj.get("heading").getAsString());
		date.set(obj.get("date").getAsString());
		imgUrl.set(obj.get("imgUrl").getAsString());
		description.set(obj.get("description").getAsString());

		isoDateFormatOne.setTimeZone(TimeZone.getTimeZone("GMT"));
		isoDateFormatTwo.setTimeZone(TimeZone.getTimeZone("GMT"));
		readableDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
		try {
			this.date.set(readableDateFormat.format(isoDateFormatOne.parse(date.get())));
		} catch(ParseException e) {
			try {
				this.date.set(readableDateFormat.format(isoDateFormatTwo.parse(date.get())));
			} catch(ParseException e1) {
				this.date.set("Unknown Date");
			}
		}
	}
}
