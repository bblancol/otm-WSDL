package com.estafeta;
 
import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.TrackingLog;
 





import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
 


import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.estafeta.businessentities.Location; 

@Path("/locationservice")
public interface WSLocation {
	
	@POST
	@Path("/registerLocation/")
	@Consumes("application/json")
	ProcessResponse registerLocation (Location oLocation, TrackingLog oTrackingLog);
	
	@GET
	@Path("/getLocation/")
	@Produces("application/json")
	ProcessResponse getLocation ();
	
}
