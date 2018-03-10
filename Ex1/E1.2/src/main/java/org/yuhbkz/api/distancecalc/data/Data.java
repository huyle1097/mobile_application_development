package org.yuhbkz.api.distancecalc.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	private String latlng1;
	private String latlng2;
	private String distance;
	public Data() {}
	
	public String getLatlng1() {
		return latlng1;
	}

	public void setLatlng1(String latlng1) {
		this.latlng1 = latlng1;
	}

	public String getLatlng2() {
		return latlng2;
	}

	public void setLatlng2(String latlng2) {
		this.latlng2 = latlng2;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Data(String latlng1, String latlng2, String distance) {
		this.latlng1 = latlng1;
		this.latlng2 = latlng2;
		this.distance = distance;
	}
}
