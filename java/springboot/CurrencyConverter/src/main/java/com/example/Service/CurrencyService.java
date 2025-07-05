package com.example.Service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {
	private final String API_URL="https://open.er-api.com/v6/latest/USD";
	public Map<String,Object> getRates(){
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.getForObject(API_URL,String.class);
		JSONObject json=new JSONObject(response);
		return json.getJSONObject("rates").toMap();
	}
	public double convert(double usdAmount, String targetCurrency) {
		Map<String,Object>rates=getRates();
		double rate=Double.parseDouble(rates.get(targetCurrency).toString());
		return usdAmount * rate;
	}
}
