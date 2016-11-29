package com.estafeta;

import java.util.Date;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.StatusResponse;
import com.estafeta.interfaceentities.TrackingLog;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.estafeta.businessentities.TransportOrder;
import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

public class TransportOrderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String operation = exchange.getIn().getHeader("operationName").toString();
		TrackingLog oTrackingLog;
		ProcessResponse oProcessResponse = new ProcessResponse();
		StatusResponse oStatusResponse = new StatusResponse();
		
		switch (operation)
		{
			case "registerUpdateDriver": 
				TransportOrder oTransportOrder = exchange.getIn().getBody(TransportOrder.class);
				oTrackingLog = exchange.getIn().getBody(TrackingLog.class);

				ProcessResponse oPR = new ProcessResponse(); 
		        oProcessResponse.setProcessDate(new Date());
		        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
		        oProcessResponse.setDestinationSystemVersion("10.0.0");
		        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+oTransportOrder.getCode());
		        
		        oStatusResponse.setCode("ERROR");
		        oStatusResponse.setErrorCode("C490");
		        oStatusResponse.setErrorDescription("Error de prueba al registar la Orden de Transporte");
		        oProcessResponse.setStatusResponse(oStatusResponse);

		        exchange.getOut().setBody(oProcessResponse);
		        break;
			default:
				String nombre2 = exchange.getIn().getBody(String.class);
		        exchange.getOut().setBody(nombre2);
				break;
			
		
		}
       
	}

}
