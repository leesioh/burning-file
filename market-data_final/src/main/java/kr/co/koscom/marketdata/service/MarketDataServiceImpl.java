package kr.co.koscom.marketdata.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.koscom.marketdata.api.MarketDataApiCaller;
import kr.co.koscom.marketdata.model.History;
import kr.co.koscom.marketdata.model.HistoryList;
import kr.co.koscom.marketdata.model.Issue;
import kr.co.koscom.marketdata.model.IssueList;
import kr.co.koscom.marketdata.model.MasterInfo;

@Service
public class MarketDataServiceImpl implements MarketDataService{

	@Autowired
	private MarketDataApiCaller marketDataApiCaller;
	
	@Override
	public IssueList getList(String marketCode) {

		return marketDataApiCaller.getList(marketCode);
	}

	@Override
	public ArrayList<HistoryList> getHistoryInfoList(String marketCode, IssueList issueList, int count) {

		Issue[] arrIssue = issueList.getIsuLists();
		ArrayList<HistoryList> historyInfoList = new ArrayList<HistoryList>();
    	
		String trnsmCycleTpCd = "M";		// 전송주기구분코드 (D:일별, W:주별, M:월별)
		String inqStrtDd = "20170101";		// 조회시작일자 (YYYYMMDD)
		String inqEndDd = "20171231";		// 조회종료일자 (YYYYMMDD)
		String reqCnt = "20";				// 요청건수 (최대 100건)
		
		if(count  < 1 || count > 600)
			count = 600;
		
		// 종목 수 만큼 반복하여 히스토리 정보를 반환하는  api call
		// 히스토리 정보 전체 목록을 반환하는 api 필요함
		for(int i=0; i<arrIssue.length; i++) {
			Issue issue = arrIssue[i];
			String isuSrtCd = issue.getIsuSrtCd();
					
			HistoryList historyList = marketDataApiCaller.getIssueHistory(marketCode, isuSrtCd, trnsmCycleTpCd, inqStrtDd, inqEndDd, reqCnt);
			
			// 12달 정보가 있는 종목으로 한정
			if(historyList.getHisLists().length < 12)
				continue;
			
			historyList.setIsuCd(issue.getIsuCd());
			historyList.setIsuKorAbbr(issue.getIsuKorAbbr());
			historyList.setIsuKorNm(issue.getIsuKorNm());
			historyList.setIsuSrtCd(issue.getIsuSrtCd());
			historyInfoList.add(historyList);
			
			// 호출 횟수 제한
			// 네트워크 응답 시간 초과를 막기 위해 제한
			if(i >= count) {
				break;
			}
		}
		
		
		return historyInfoList;
	}

	@Override
	public ArrayList<Issue> getRecommendIssues(ArrayList<HistoryList> historyInfoList, int month, String marketCode, int diffCmp) {

		// 고가와 시가의 차이가 15% 이상인 종목 선정
		ArrayList<Issue> bestIssues = new ArrayList<Issue>();
		ArrayList<Issue> recommendIssues = new ArrayList<Issue>();
		
		month = 12-month;	// 역순으로 배열에 저장되어 있음
		if(diffCmp == 0)
			diffCmp = 15;
		
		for(HistoryList historyInfo : historyInfoList) {
			// 해당 월의 고가와 시가의 차이가 15% 이상 종목 선정
			History history = historyInfo.getHisLists()[month];
			
			if(month >= 0 && month <= 11 && history != null){
				long opnPrc = Long.parseLong(history.getOpnprc());
				long hgPrc = Long.parseLong(history.getHgprc());
				
				double diff = ((double)hgPrc - (double)opnPrc)/ (double)opnPrc * 100.0;
				
				if (diff >= diffCmp) {
				
					Issue issue = new Issue();
					
					issue.setIsuCd(historyInfo.getIsuCd());
					issue.setIsuKorAbbr(historyInfo.getIsuKorAbbr());
					issue.setIsuKorNm(historyInfo.getIsuKorNm());
					issue.setIsuSrtCd(historyInfo.getIsuSrtCd());
			
					bestIssues.add(issue);
				}
			}
			
		}
		
		
		// 선정된 종목에 대해  master api를 호출하여 재무정보와 업종 데이터 수신
		// 재무정보를 바탕으로 추천 종목 후보군 선정
		// 기준 
		// 		pbr 1.3 이하
		//		per 7 이상 13 이하
		for(Issue issue : bestIssues) {
		
			MasterInfo masterInfo = marketDataApiCaller.getMasterInfo(marketCode, issue.getIsuSrtCd());
			
			boolean cond1 = false;
			boolean cond2 = false;
			
			if (masterInfo.getPbr() <= 1.3) 
				cond1 = true;
			
			if (masterInfo.getPer() <= 13 && masterInfo.getPer() >= 7)
				cond2 = true;
			
			if(cond1 && cond2) {
				issue.setIdxIndUpclssCd(masterInfo.getIdxIndUpclssCd());
				recommendIssues.add(issue);
			}
		}
			
		// 언론 노출 빈도 적용하여 추천 종목 선정
		// TODO 추후 작업

		
		return recommendIssues;
	}

	@Override
	public MasterInfo getMasterInfo(String marketCode, String issueCode) {
		
		return marketDataApiCaller.getMasterInfo(marketCode, issueCode);
	}
}
