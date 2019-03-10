package com.demo.testOne;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DemoTestOne {
	
    @Test
	public void sample() throws ClientProtocolException, IOException {
		
		HttpGet httpGet = new HttpGet("https://reqres.in/api/users");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity hEntity = httpResponse.getEntity();
		String responseAsString = EntityUtils.toString(hEntity,"UTF-8");
		JSONObject responseAsJson = new JSONObject(responseAsString);
		Header[] header = httpResponse.getAllHeaders();
		HashMap<String, String> hmp = new HashMap<String, String>();
		for(Header head: header) {
			
			hmp.put(head.getName(), head.getValue());
			
		}
		System.out.println(statusCode);
		System.out.println(responseAsJson);
		System.out.println(hmp);
		
		
		
	}
	
	

}
