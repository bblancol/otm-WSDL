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
public interface WSEmployee {
	
	@WebMethod
	ProcessResponse registerUpdateDriver (@WebParam(name="employee") Employee oEmployee,
			@WebParam(name="trackingLog") TrackingLog oTrackingLog);
	

	@WebMethod
    ProcessResponse changeStatusDriver (@WebParam(name="employeeCode") String employeeCode,
    							@WebParam(name="status") Status oStatus,
    							@WebParam(name="trackingLog") TrackingLog oTrackingLog);
}
