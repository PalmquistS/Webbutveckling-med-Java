package beans;

import database.SQLconFeeds;

public class NewFeedBean {
	private String feedContent;
	private String feedTag;

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getFeedTag() {
		return feedTag;
	}

	public void setFeedTag(String feedTag) {
		this.feedTag = feedTag;
	}

	public boolean newpostToSQL(NewFeedBean bean) {

		if (SQLconFeeds.connectSQL()) {
			return SQLconFeeds.addFeedToSQL(bean);
		}

		return false;
	}

}
