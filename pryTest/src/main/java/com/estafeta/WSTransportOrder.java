package com.estafeta;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.TrackingLog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NameBinding;

import com.estafeta.businessentities.TransportOrder;
import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

@WebService	
public interface WSTransportOrder {
	
	@WebMethod
	ProcessResponse registerTransportOrder (@WebParam(name="transportOrder") TransportOrder oTransportOrder,
			@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	
}
