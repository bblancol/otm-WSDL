package com.estafeta;

import java.util.Date;

import com.estafeta.interfaceentities.ProcessResponse;
import com.estafeta.interfaceentities.StatusResponse;
import com.estafeta.interfaceentities.TrackingLog;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.estafeta.businessentities.Employee;
import com.estafeta.businessentities.Status;
import com.estafeta.businessentities.TransportUnit;

public class EmployeeProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String operation = exchange.getIn().getHeader("operationName").toString();
		TrackingLog oTrackingLog;
		ProcessResponse oProcessResponse = new ProcessResponse();
		StatusResponse oStatusResponse = new StatusResponse();
		
		switch (operation)
		{
			case "registerUpdateDriver": 
				Employee oEmployee = exchange.getIn().getBody(Employee.class);
				oTrackingLog = exchange.getIn().getBody(TrackingLog.class);
		       	
				/*oEmployee.getCode();
		        oEmployee.getFirstName();
		        oEmployee.getMiddleName();
		        oEmployee.getLastName1();
		        oEmployee.getLastName2();
		        oEmployee.getEmployeeType().getCode();
		        oEmployee.getDrivingLicenceNumber();
		        oEmployee.getDrivingLicenceDueDate();
		        oEmployee.getDrivingLicenceIssueState().getCode();
		        oEmployee.getDefaultWorkLocation().getCode();
		        oEmployee.getStatus().getStatusReason().getDescription();*/
				ProcessResponse oPR = new ProcessResponse(); 
		        oProcessResponse.setProcessDate(new Date());
		        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
		        oProcessResponse.setDestinationSystemVersion("10.0.0");
		        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+oEmployee.getCode());
		        
		        oStatusResponse.setCode("ERROR");
		        oStatusResponse.setErrorCode("C490");
		        oStatusResponse.setErrorDescription("Error de prueba al registar conductor");
		        oProcessResponse.setStatusResponse(oStatusResponse);

		        exchange.getOut().setBody(oProcessResponse);
		        break;
		        
			case "changeStatusDriver": 
				String transportUnitCode = exchange.getIn().getBody(String.class);
				Status oStatus = exchange.getIn().getBody(Status.class);
				oTrackingLog = exchange.getIn().getBody(TrackingLog.class);
				 
		        oProcessResponse.setProcessDate(new Date());
		        oProcessResponse.setDestinationSystem("ORACLE TRANSPORTATION MANAGEMENT SYSTEM");
		        oProcessResponse.setDestinationSystemVersion("10.0.0");
		        oProcessResponse.setProcessID(((Integer)(new java.util.Random().nextInt())).toString()+ transportUnitCode);

		        oStatusResponse= new StatusResponse();
		        oStatusResponse.setCode("ERROR");
		        oStatusResponse.setErrorCode("C491");
		        oStatusResponse.setErrorDescription("Error de prueba al cambiar de Estado del conductor");
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
