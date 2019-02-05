package com.wipro.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.webcrawler.pojo.SiteMap;
import com.wipro.webcrawler.service.WebCrawlerService;

@RestController
public class WebCrawlerController {

	@Autowired
	private WebCrawlerService webCrawlerService;
	
	@RequestMapping(path= {"/crawlweb"}, method= {RequestMethod.GET}, produces= {"application/xml", "application/json"})
	public SiteMap crawlweb(@RequestParam("crawlurl") String url) {
		System.out.println("Crawling URL : "+ url+", for links and images (Xml format)");
		SiteMap siteMap = null;
		try {
			siteMap = webCrawlerService.getSiteMap(url);
		} catch (Exception e) {
			siteMap = new SiteMap();
		}
		System.out.println("Crawl completed for URL : "+url);
		return siteMap;
	}
	
	@RequestMapping(path= {"/crawlweb"}, method= {RequestMethod.GET}, produces= {"text/plain"})
	public String crawlwebText(@RequestParam("crawlurl") String url) {
		System.out.println("Crawling URL : "+ url+", for links and images (Text format)");
		SiteMap siteMap = null;
		try {
			siteMap = webCrawlerService.getSiteMap(url);
		} catch (Exception e) {
			siteMap = new SiteMap();
		}
		System.out.println("Crawl completed for URL : "+url);
		StringBuffer sb = new StringBuffer();
		
		siteMap.getUrls().forEach(u -> sb.append(u.getLoc()).append("\n"));
		siteMap.getImages().forEach(u -> sb.append(u.getLoc()).append("\n"));
		return sb.toString();
	}
	
	
}
