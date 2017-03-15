package lib;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

/**
 * @author Michael
 * @since 13 March 2017
 * @version 1.0
 */

public class Article {

	private String date;
	private String name;
	private String[] tags;
	private String summary;
	private ImageIcon icon;
	
	public Article(String date, String name, String summary, ImageIcon icon) {
		this.date = date;
		this.name = name;
		this.summary = summary;
	}
	
	public Article(String name) {
		this(null, name, null, null);
	}
	
	public Article(String name, String summary) {
		this(null, name, summary, null);
	}
	
	public Article(String name, String summary, ImageIcon icon) {
		this(null, name, summary, icon);
	}
	
	public Article(String date, String name, String summary, ImageIcon icon, String[] customTags) {
		this.date = date;
		this.name = name;
		this.summary = summary;
		// Create tags array
		tags = new String[customTags.length];
		Arrays.fill(tags, customTags);
	}
	
	// Get the array of tags
	public String[] getTags() {
		if (tags == null) {
			return generateTags();
		} else {
			return tags;
		}
	}
	
	public void addCustomTags(String[] tags2) {
		if (tags == null) {
			tags = new String[tags2.length];
			Arrays.fill(tags, tags2);
		} else {
			// Combine tag arrays
			Set<String> tagSet = new HashSet<String>();
			for (String s : tags) {
				tagSet.add(s);
			}
			for (String s : tags2) {
				tagSet.add(s);
			}
			// Put all tags from the set into global array "tags"
			tags = new String[tagSet.size()];
			int count = 0;
			for (String s : tagSet) {
				tags[count] = s;
				count++;
			}
		}
	}
	
	// Generate the tags
	private String[] generateTags() {
		String[] titleKeys = name.split(" ");
		// TODO: again remove articles/prepositions/words that aren't nouns
		return titleKeys;
	}
	
}
