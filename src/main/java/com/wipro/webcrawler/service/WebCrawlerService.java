package com.wipro.webcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.wipro.webcrawler.pojo.Image;
import com.wipro.webcrawler.pojo.SiteMap;
import com.wipro.webcrawler.pojo.Url;

@Service
public class WebCrawlerService {
        /*Comment is added here*/
	public SiteMap getSiteMap(String url) throws Exception {
		SiteMap siteMap = new SiteMap();
		
		processLinks(siteMap, url, url);
		processImages(siteMap, url, url);
		
		return siteMap;
	}

	private void processLinks(SiteMap siteMap, String domain, String URL) throws Exception {
		if (siteMap.getUrls().contains(new Url(URL))) {
			return;
		}
		Document doc = null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error connecting to URL : " + URL);
		}

		siteMap.addUrl(new Url(URL));

		// get all links and recursively call the processPage method
		Elements links = doc.getElementsByTag("a");
		String absUrl = null;
		for (Element link : links) {
			absUrl = link.attr("abs:href");
			if (absUrl.contains(domain)) {
				processLinks(siteMap, domain, absUrl);
			}
		}
	}

	private void processImages(SiteMap siteMap, String domain, String URL) throws Exception {

		Document doc = null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error connecting to URL : " + URL);
		}

		Elements images = doc.getElementsByTag("img");
		String absUrl = null;
		for (Element img : images) {
			absUrl = img.attr("abs:src");
			siteMap.addImage(new Image(absUrl));
		}

	}

}
