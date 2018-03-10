package org.yuhbkz.api.distancecalc.service;
import org.yuhbkz.api.distancecalc.data.Data;

public class Service {
	
	public Data responeData(String geocode1, String geocode2) {
		Double distance = Calculate(geocode1, geocode2);
		distance = (double) Math.round(distance);
		Data lastData = new Data(geocode1,geocode2,distance.toString());
		return lastData;
	}
	
	public Double Calculate(String geocode1, String geocode2) {
		String[] latlng1 = geocode1.split(",");
		String[] latlng2 = geocode2.split(",");
		Double lat1 = Double.parseDouble(latlng1[0]);
		Double lng1 = Double.parseDouble(latlng1[1]);
		Double lat2 = Double.parseDouble(latlng2[0]);
		Double lng2 = Double.parseDouble(latlng2[1]);
		  Double R = 6371.0; // Radius of the earth in km
		  Double dLat = deg2rad(lat2-lat1);  // deg2rad below
		  Double dLng = deg2rad(lng2-lng1); 
		  Double a = 
		    Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
		    Math.sin(dLng/2) * Math.sin(dLng/2)
		    ; 
		  Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		  Double d = R * c; // Distance in km?
		  return d;
	}
	public Double deg2rad(Double deg) {
		return deg * (Math.PI/180);
	}

}
