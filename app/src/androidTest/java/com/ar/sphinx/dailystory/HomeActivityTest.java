package com.ar.sphinx.dailystory;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ar.sphinx.dailystory.ui.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sphinx.ar on 16/09/18.
 */
//UI test for home activity views, similar for other activities.
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

	@Rule
	public ActivityTestRule<HomeActivity> mActivityRule =
			new ActivityTestRule<>(HomeActivity.class);

	@Test
	public void checkViewsDisplay() {

		onView(withId(R.id.loading_layout_one))
				.check(matches(isDisplayed()));
		onView(withId(R.id.loading_layout_two))
				.check(matches(isDisplayed()));
		onView(withId(R.id.tv_newsFeed))
				.check(matches(isDisplayed()));
		onView(withId(R.id.spinner))
				.check(matches(isDisplayed()));


	}

}
