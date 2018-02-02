package kr.co.koscom.marketdata.service;

import java.util.ArrayList;

import kr.co.koscom.marketdata.model.HistoryList;
import kr.co.koscom.marketdata.model.Issue;
import kr.co.koscom.marketdata.model.IssueList;
import kr.co.koscom.marketdata.model.MasterInfo;

public interface MarketDataService {
	
	public IssueList getList(String marketCode);
	
	public ArrayList<HistoryList> getHistoryInfoList(String marketCode, IssueList issueList, int count);
	
	public ArrayList<Issue> getRecommendIssues(ArrayList<HistoryList> historyInfoList, int month, String marketCode, int diff);
	
	public MasterInfo getMasterInfo(String marketCode, String issueCode);
}
