package com.estafeta.general;

import com.estafeta.interfaceentities.TrackingLog;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.estafeta.businessentities.TransportUnit;

public class GeneralProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String operation = exchange.getIn().getHeader("operationName").toString();
		switch (operation)
		{
			case "consultarEstadoTransaccion": 
				TransportUnit oTransportUnit = exchange.getIn().getBody(TransportUnit.class);
				TrackingLog oTrackingLog = exchange.getIn().getBody(TrackingLog.class);
		        exchange.getOut().setBody("Registrando la UT: " + oTransportUnit.getCode() + ". Log: " + oTrackingLog.getSystem() + " " + oTrackingLog.getVersion());

				break;
			default:
				String nombre2 = exchange.getIn().getBody(String.class);
		        exchange.getOut().setBody(nombre2);
				break;
			
		
		}
       
	}

}
