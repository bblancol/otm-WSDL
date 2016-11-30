package com.estafeta;

import java.util.Date;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.StatusResponse;
import com.estafeta.interfaceentities.TrackingLog;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.estafeta.businessentities.Location; 

public class LocationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		//String operation = exchange.getIn().getHeader("operationName").toString();
		TrackingLog oTrackingLog;
		ProcessResponse oProcessResponse = new ProcessResponse();
		StatusResponse oStatusResponse = new StatusResponse();
		
		Location oLocation = exchange.getIn().getBody(Location.class);
		oTrackingLog = exchange.getIn().getBody(TrackingLog.class);

		ProcessResponse oPR = new ProcessResponse(); 
        oProcessResponse.setProcessDate(new Date());
        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
        oProcessResponse.setDestinationSystemVersion("10.0.0");
        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+oLocation.getCode());
        
        oStatusResponse.setCode("ERROR");
        oStatusResponse.setErrorCode("C490");
        oStatusResponse.setErrorDescription("Error de prueba al registar la ubicación");
        oProcessResponse.setStatusResponse(oStatusResponse);

        exchange.getOut().setBody(oProcessResponse);
		       
	}

}
