package com.estafeta.general;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.TrackingLog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NameBinding;

@WebService	
public interface GeneralInbound {
	@WebMethod
    ProcessResponse consultarEstadoTransaccion (@WebParam(name="processID") String processID,
    							@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	
}
