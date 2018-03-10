package org.yuhbkz.api.distancecalc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yuhbkz.api.distancecalc.data.Data;
import org.yuhbkz.api.distancecalc.service.Service;

@Path("/calc")
public class DistanceCalc {
	
	Service calcService = new Service();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String description() {
		return "API to calculate distance between 2 geocode";
	}
	@GET
	@Path("/origin=\"{latlng1}\"&destination=\"{latlng2}\"")
	@Produces(MediaType.APPLICATION_JSON)
	public Data calc(@PathParam("latlng1") String latlng1,@PathParam("latlng2") String latlng2) {
		return calcService.responeData(latlng1, latlng2);
	}
	
}
