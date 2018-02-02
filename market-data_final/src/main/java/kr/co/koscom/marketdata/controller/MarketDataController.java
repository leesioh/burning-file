package kr.co.koscom.marketdata.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.koscom.marketdata.model.HistoryList;
import kr.co.koscom.marketdata.model.Issue;
import kr.co.koscom.marketdata.model.IssueList;
import kr.co.koscom.marketdata.model.MasterInfo;
import kr.co.koscom.marketdata.service.MarketDataService;

@Controller
public class MarketDataController {
	
	
	@Autowired
	private MarketDataService marketDataService;
    
	
	/*
	 * 찾고자 하는 월을 선택하는 view page
	 */
    @RequestMapping(path = "/select")
    public String selectMonth() {
        return "selectMonth";
    }
    
    
    /*
     * 월을 입력 받아 추천 종목을 선정하여 반환
     */
    @RequestMapping(path = "/list")
    public String list(@RequestParam(value = "month") int month, 
    		@RequestParam(value = "diff") int diff, 
    		@RequestParam(value = "count") int count, 
    		Model model) {
    	
    	String marketCode = "kospi";
    	
    	// 주식 종목 리스트 호출
    	IssueList issueList = marketDataService.getList(marketCode);
    	
    	// 종목별 히스토리 호출
    	ArrayList<HistoryList> historyInfoList = marketDataService.getHistoryInfoList(marketCode, issueList, count);  	
    	
    	// 추천 종목 선정
    	ArrayList<Issue> recommendIssues = marketDataService.getRecommendIssues(historyInfoList, month, marketCode, diff);
    	
    	model.addAttribute("month", month);
    	model.addAttribute("recommendIssues", recommendIssues);
    	
    	
    	return "recommendIssues";
    }
    
    
    @RequestMapping(path = "/issue")
    public String issueInfo(@RequestParam(value = "isuSrtCd") String isuSrtCd, Model model) {
    	
    	String marketCode = "kospi";
    	
    	MasterInfo masterInfo = marketDataService.getMasterInfo(marketCode, isuSrtCd); 
    	
    	model.addAttribute("masterInfo", masterInfo);
    	
        return "issueInfo";
    }

}
