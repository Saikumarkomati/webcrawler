package com.wipro.webcrawler.test;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WebCrawlerTest {

	public static void main(String[] args) {
		String url = "http://localhost:8080/crawlweb?crawlurl=http://www.mit.edu/";
		
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("perameters", headers);
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, entity, String.class);
		
		System.out.println(response.getBody());
		
	}
	
}
