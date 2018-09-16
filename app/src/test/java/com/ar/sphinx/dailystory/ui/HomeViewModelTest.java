package com.ar.sphinx.dailystory.ui;

import com.ar.sphinx.dailystory.data.DataManager;
import com.ar.sphinx.dailystory.data.model.api.Article;
import com.ar.sphinx.dailystory.data.model.api.NewsResponse;
import com.ar.sphinx.dailystory.ui.home.HomeNavigator;
import com.ar.sphinx.dailystory.ui.home.HomeViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;

/**
 * Created by sphinx.ar on 16/09/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeViewModelTest {

	@Mock
	HomeNavigator homeNavigator;

	@Mock
	private DataManager dataManager;

	private HomeViewModel homeViewModel;
	private TestScheduler mTestScheduler;

	@BeforeClass
	public static void onlyOnce() throws Exception {
	}

	@Before
	public void setup() throws Exception {
		mTestScheduler = new TestScheduler();
		TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
		homeViewModel = new HomeViewModel(dataManager,testSchedulerProvider);
		homeViewModel.setNavigator(homeNavigator);
	}

	@Test
	public void getNytRecentNews() {
		ArrayList<Article> articles = new ArrayList<>();
		Article article = Article.create("author","title","desc","url",
				"date","content","urlImage");
		articles.add(article);
		NewsResponse newsResponse = NewsResponse.create("200",1,articles);

		doReturn(Single.just(newsResponse))
				.when(dataManager)
				.doNytTrendingApiCall();

		mTestScheduler.triggerActions();
		homeViewModel.getNYTTrendingNews();
	}

	@After
	public void tearDown() throws Exception {

	}
}
