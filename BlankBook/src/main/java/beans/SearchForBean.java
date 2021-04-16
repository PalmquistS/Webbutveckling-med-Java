package beans;

import java.util.ArrayList;

import database.SQLconFeeds;

public class SearchForBean {
	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getAnswerFromSQL(ArrayList<String> list) {

		if (SQLconFeeds.connectSQL()) {

			ArrayList<String> returnList = SQLconFeeds.getSearchForFeedsFromSQL(list, question);
			return returnList;

		}
		return null;

	}

}
