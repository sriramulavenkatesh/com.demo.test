package com.demo.testOne;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTwo {
	
	@Test
	public void samp() throws ClientProtocolException, IOException {
	 
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Content-Type", "application/json");
		HttpGet httpget = new HttpGet("https://reqres.in/api/users");
		for(Entry<String, String> mp:hm.entrySet()) {
			
			httpget.addHeader(mp.getKey(), mp.getValue());
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = httpClient.execute(httpget);
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity responseAsEntity = httpResponse.getEntity();
		String responseAsString = EntityUtils.toString(responseAsEntity);
		JSONObject responseAsJson = new JSONObject(responseAsString);
		Assert.assertEquals(responseCode, 200);
		System.out.println(responseCode);
		//String pageValue = TestUtil.getValueByJPath(responseAsJson, "/per_page");
		String id = TestUtil.getValueByJPath(responseAsJson, "/data[0]/id");
		String name = TestUtil.getValueByJPath(responseAsJson, "/data[2]/last_name");
		System.out.println(id);
		System.out.println(name);
		
		
		
		
		
		
		
		
		
		
		
		/*HashMap<String, String> hmp = new HashMap<String, String>();
		Header[] headers = httpResponse.getAllHeaders();
		for(Header head:headers) {
			
			hmp.put(head.getName(), head.getValue());
			
		}
	   System.out.println(hmp);	*/
	}
    
	public static void splitRegex() {
		
		String jpath = "/per_page/rt";
		String[] s = jpath.split("/");
		System.out.println(s.length);
		for(String st:s) {
			
			System.out.println(st);
			
			
		}
		
		
		
	}

}
