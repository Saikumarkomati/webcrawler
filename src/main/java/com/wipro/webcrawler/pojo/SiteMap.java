package com.wipro.webcrawler.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SiteMap {
	
	@XmlElement(name="url")
	private List<Url> urls = new ArrayList<Url>();
	@XmlElement(name="image")
	private List<Image> images = new ArrayList<Image>();
	
	public SiteMap() {
	}
	
	public void addUrl(Url url) {
		urls.add(url);
	}
	
	public void addImage(Image img) {
		images.add(img);
	}
	
	public List<Url> getUrls(){
		return this.urls;
	}
	
	public List<Image> getImages(){
		return this.images;
	}
	
	
	
	

}

