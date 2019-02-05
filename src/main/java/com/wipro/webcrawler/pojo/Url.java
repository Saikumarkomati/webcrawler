package com.wipro.webcrawler.pojo;

import javax.xml.bind.annotation.XmlElement;

public class Url{
	
	public Url() {
	}
	public Url(String url) {
		this.loc = url;
	}
	
	public String getLoc() {
		return this.loc;
	}
	
	@XmlElement
	private String loc;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Url other = (Url) obj;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}
	
}

