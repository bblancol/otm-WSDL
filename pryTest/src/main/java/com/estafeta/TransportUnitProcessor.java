package com.estafeta;

import java.util.Date;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.StatusResponse;
import com.estafeta.interfaceentities.TrackingLog;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

public class TransportUnitProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String operation = exchange.getIn().getHeader("operationName").toString();
		TrackingLog oTrackingLog;
        ProcessResponse oProcessResponse= new ProcessResponse();
        StatusResponse oStatusResponse = new StatusResponse();
        
		switch (operation)
		{
			case "registerUpdateTransportUnit": 
				TransportUnit oTransportUnit = exchange.getIn().getBody(TransportUnit.class);
				oTrackingLog = exchange.getIn().getBody(TrackingLog.class);
		        
		        /*oTransportUnit.getCode();
		        oTransportUnit.getName();
		        oTransportUnit.getRegistrationNumber();
		        oTransportUnit.getYear();
		        oTransportUnit.getLicencePlate();
		        oTransportUnit.getVehicleNumber();
		        oTransportUnit.getCirculationCard();
		        oTransportUnit.getModel();
		        oTransportUnit.getBrand();
		        oTransportUnit.getManufacturerName();
		        oTransportUnit.getManufacturerSerialNumber();
		        oTransportUnit.getEngineSerialNumber();
		        oTransportUnit.getMaintenanceLocation().getAddress();
		        oTransportUnit.getStorageCapacity();
		        oTransportUnit.getCompanyOwner();
		        oTransportUnit.getTransportUnitType().getDenomination();
		        oTransportUnit.getTransportUnitSubType().getDenomination();
		        oTransportUnit.getTransportUnitSubType().getDenominationOTM();
		        oTransportUnit.getLinkedTransportUnit().getTransportUnitSubType().getDenominationOTM();
		        oTransportUnit.getStatus().getCode();
		        oTransportUnit.getStatus().getStatusReason().getDescription();
		        */
		        oProcessResponse.setProcessDate(new Date());
		        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
		        oProcessResponse.setDestinationSystemVersion("10.0.0");
		        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+oTransportUnit.getCode());
	      
		        oStatusResponse.setCode("ERROR");
		        oStatusResponse.setErrorCode("C485");
		        oStatusResponse.setErrorDescription("Error de prueba al registrar Unidad de Transporte");
		        oProcessResponse.setStatusResponse(oStatusResponse);

		        exchange.getOut().setBody(oProcessResponse);

				break;
				
			case "changeStatusTransportUnit": 
				String transportUnitCode = exchange.getIn().getBody(String.class);
				Status oStatus = exchange.getIn().getBody(Status.class);
				oTrackingLog = exchange.getIn().getBody(TrackingLog.class);
				 
		        oProcessResponse.setProcessDate(new Date());
		        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
		        oProcessResponse.setDestinationSystemVersion("10.0.0");
		        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+ transportUnitCode);

		        oStatusResponse.setCode("ERROR");
		        oStatusResponse.setErrorCode("C485");
		        oStatusResponse.setErrorDescription("Error de prueba al cambiar de Estado la Unidad de Transporte");
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
