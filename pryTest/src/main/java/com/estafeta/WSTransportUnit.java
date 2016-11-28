package com.estafeta;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.TrackingLog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NameBinding;

import com.estafeta.businessentities.Employee;
import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

@WebService	
public interface WSTransportUnit {
	@WebMethod
    ProcessResponse registerUpdateTransportUnit (@WebParam(name="transporUnit") TransportUnit oTransportUnit,
    							@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	
	
	@WebMethod
    ProcessResponse changeStatusTransportUnit (@WebParam(name="transportUnitCode") String transportUnitCode,
    							@WebParam(name="status") Status oStatus,
    							@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	
}
