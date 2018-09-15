package com.ar.sphinx.dailystory.ui.home.todaynews;

import android.databinding.ObservableField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.ar.sphinx.dailystory.data.model.api.Article;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by sphinx.ar on 15/09/18.
 */
public class NewsViewModel {

	private SimpleDateFormat isoDateFormatOne = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
	private SimpleDateFormat isoDateFormatTwo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
	private SimpleDateFormat readableDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.US);

	public ObservableField<String> heading = new ObservableField<>();
	public ObservableField<String> date = new ObservableField<>();
	public ObservableField<String> imgUrl = new ObservableField<>();

	public NewsViewModel(Article article) {
		this.heading.set(article.title());
		this.imgUrl.set(article.urlToImage());
		setDate(article.publishedAt());
	}
	public void setDate(String date) {
		isoDateFormatOne.setTimeZone(TimeZone.getTimeZone("GMT"));
		isoDateFormatTwo.setTimeZone(TimeZone.getTimeZone("GMT"));
		readableDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
		try {
			this.date.set(readableDateFormat.format(isoDateFormatOne.parse(date)));
		} catch(ParseException e) {
			try {
				this.date.set(readableDateFormat.format(isoDateFormatTwo.parse(date)));
			} catch(ParseException e1) {
				this.date.set("Unknown Date");
			}
		}
	}
}
