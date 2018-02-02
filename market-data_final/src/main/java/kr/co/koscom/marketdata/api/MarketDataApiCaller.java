package kr.co.koscom.marketdata.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.koscom.marketdata.model.HistoryList;
import kr.co.koscom.marketdata.model.IssueList;
import kr.co.koscom.marketdata.model.MasterInfo;
import kr.co.koscom.marketdata.util.HttpClientUtil;

@Component
public class MarketDataApiCaller {

	private static String URI_PREFIX = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks";
	private static String URI_POSTFIX = "";
	
	private static String APIKEY = "l7xx3a11a559765b44eb9b27ad80a89e06eb";
	
	@Autowired
	private HttpClientUtil httpClientUtil;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	/*
	 * 종목 리스트 API 호출
	 * @marketCode : 마켓 코드(kospi/kosdaq)
	 */
	public IssueList getList(String marketCode) {
		
		try {
			URI_POSTFIX = "/lists";
			String jsonStr = httpClientUtil.execute(URI_PREFIX + "/" + marketCode + URI_POSTFIX + "?apikey=" + APIKEY);
			
			IssueList issueList = objectMapper.readValue(jsonStr, IssueList.class);
			
			return issueList;
		} catch(Exception e) {
			
		}
		return null;
	}
	
	
	/*
	 * 종목 히스토리 API 호출
	 * @marketCode : 마켓 코드(kospi/kosdaq)
	 * @issueCode : 종목코드 
	 * @trnsmCycleTpCd : 전송주기구분코드 (D:일별, W:주별, M:월별)
	 * @inqStrtDd : 조회시작일자 (YYYYMMDD)
	 * @inqEndDd : 조회종료일자 (YYYYMMDD)
	 * @reqCnt : 요청건수 (최대 100건)
	 */
	public HistoryList getIssueHistory(String marketCode, String issueCode, String trnsmCycleTpCd, String inqStrtDd, String inqEndDd, String reqCnt) {
		try {
			URI_POSTFIX = "/history";
			
			String url = URI_PREFIX + "/" + marketCode + "/" + issueCode +  URI_POSTFIX
					+ "?apikey=" + APIKEY 
					+ "&trnsmCycleTpCd=" + trnsmCycleTpCd
					+ "&inqStrtDd=" + inqStrtDd
					+ "&inqEndDd=" + inqEndDd
					+ "&reqCnt=" + reqCnt;
						
			String jsonStr = httpClientUtil.execute(url);
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			JsonNode node = objectMapper.readTree(jsonStr);
			
			HistoryList historyList = objectMapper.readValue(node.findValue("result").toString(), HistoryList.class);
			
			
			return historyList;
		} 		catch (JsonProcessingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	
	/*
	 * 종목의 마스터 정보 반환 API 호출
	 * @marketCode : 마켓 코드(kospi/kosdaq)
	 * @issueCode : 종목코드 
	 */
	public MasterInfo getMasterInfo(String marketCode, String issueCode) {
		try {
			URI_POSTFIX = "/master";
			String jsonStr = httpClientUtil.execute(URI_PREFIX + "/" + marketCode + "/" + issueCode +  URI_POSTFIX + "?apikey=" + APIKEY);

			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			JsonNode node = objectMapper.readTree(jsonStr);
			
			MasterInfo masterInfo = objectMapper.readValue(node.findValue("result").toString(), MasterInfo.class);
			
			
			return masterInfo;
		} 		catch (JsonProcessingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		return null;
	}
}
