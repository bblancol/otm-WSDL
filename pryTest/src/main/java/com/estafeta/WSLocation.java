package com.estafeta;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.TrackingLog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NameBinding;

import com.estafeta.businessentities.Employee;
import com.estafeta.businessentities.Location;
import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

@WebService	
public interface WSLocation {
	
	@WebMethod
	ProcessResponse registerLocation (@WebParam(name="location") Location oLocation,
			@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	
}
