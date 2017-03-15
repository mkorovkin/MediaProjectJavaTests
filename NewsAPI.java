package lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @since 13 March 2017
 * @version 1.0
 */

public abstract class NewsAPI {

	private List<Article> articles;
	private String APIsource = ""; // This is the name of the news station
	
	public NewsAPI(String name) {
		APIsource = name;
		articles = new ArrayList<Article>();
		
		fill();
	}
	
	public List<Article> getArticles() {
		return new ArrayList(articles);
	}
	
	public abstract Article[] getArticles(String filter);
	
	public int howMany() {
		if (articles == null) {
			return -1;
		} else {
			return articles.size();
		}
	}
	
	public abstract double getProgress();
	
	public abstract void fill();
	
}
