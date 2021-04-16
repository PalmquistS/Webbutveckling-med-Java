package beans;

import java.util.ArrayList;

import database.SQLconFeeds;

public class AllFeedsBean {

	private ArrayList<String> allFeedsBean;

	public ArrayList<String> getAllFeedsBean() {
		return allFeedsBean;
	}

	public void setAllFeedsBean(ArrayList<String> allFeedsBean) {
		this.allFeedsBean = allFeedsBean;
	}

	public void addToAllFeesdBean(String word) {
		this.allFeedsBean.add(word);
	}

	public Integer getAllFeesdBeanSize() {
		return allFeedsBean.size();
	}

	public String getAllFeesdBean(int index) {
		return allFeedsBean.get(index);
	}

	public ArrayList<String> getAllFeedsFromSQL(ArrayList<String> list) {

		if (SQLconFeeds.connectSQL()) {
			return SQLconFeeds.getFeedsFromSQL(list);

		}
		return null;

	}
}
